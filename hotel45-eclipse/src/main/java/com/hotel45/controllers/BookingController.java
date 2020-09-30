	package com.hotel45.controllers;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel45.dto.BookingDto;
import com.hotel45.model.Booking;
import com.hotel45.services.BookingService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/api/bookings")
public class BookingController {

	@Autowired
	private BookingService service;

	//GET'S ------------------------
	@GetMapping(value={"","/"})
	public List<BookingDto> listBookings() {
		List<Booking> listBookings = service.findAllBookings();
		List<BookingDto> listBookingsDTO = listBookings.stream().map(obj -> new BookingDto(obj)).collect(Collectors.toList());
		return listBookingsDTO;
	}

	@GetMapping("/{id}")
	public Booking listBookingById(@PathVariable Integer id) {
//		BookingDto bookingDto = new BookingDto(service.findBookingById(id));
		return service.findBookingById(id);
	}

	@GetMapping("/customer{id}")
	public List<BookingDto> listAllBookingsByCustomer(@PathVariable Integer id) {
		List<Booking> customersFound = service.findAllBookingsByCustomer(id);
		List<BookingDto> customersFoundDTO = customersFound.stream().map(obj -> new BookingDto(obj)).collect(Collectors.toList());
		return customersFoundDTO;
	}

	@GetMapping("/active/customer{id}")
	public List<BookingDto> listActiveBookingsByCustomer(@PathVariable Integer id) {
		List<Booking> customersFound = service.findActiveBookingsByCustomer(id);
		List<BookingDto> customersFoundDTO = customersFound.stream().map(obj -> new BookingDto(obj)).collect(Collectors.toList());
		return customersFoundDTO;
	}

	
	//POST'S ------------------------
	@PostMapping("/add")
	public Booking addNewBooking(@Valid @RequestBody BookingDto bookingDTO) {
		Booking booking = service.fromDTO(bookingDTO);
		Booking addBooking = service.saveBooking(booking);
		return addBooking;
	}
	
	
	//PUT'S ------------------------
	@PutMapping("/update{id}")
	public Booking updateBooking(@Valid @RequestBody BookingDto updateBookingDTO, @PathVariable Integer id) {
		Booking updateBooking = service.fromDTO(updateBookingDTO);
		updateBooking.setBookingId(id);
		return service.saveBooking(updateBooking);
	}
	
	
	//DELETE'S ------------------------
	@DeleteMapping("/delete{id}")
	public void deleteBookingById(@PathVariable Integer id) {
		service.deleteBookingById(id);
	}

}
