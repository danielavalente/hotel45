package com.hotel45.controllers;

import java.util.Date;
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
import com.hotel45.dto.NewBookingDto;
import com.hotel45.model.Booking;
import com.hotel45.model.Customer;
import com.hotel45.services.BookingService;
import com.hotel45.services.CustomerService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/api/bookings")
public class BookingController {

	@Autowired
	private BookingService service;

	@Autowired
	private CustomerService customerService;

	// GET'S ------------------------
	@GetMapping(value = { "", "/" })
	public List<BookingDto> listBookings() {
		List<Booking> listBookings = service.findAllBookings();
		List<BookingDto> listBookingsDTO = listBookings.stream().map(obj -> new BookingDto(obj))
				.collect(Collectors.toList());
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
		List<BookingDto> customersFoundDTO = customersFound.stream().map(obj -> new BookingDto(obj))
				.collect(Collectors.toList());
		return customersFoundDTO;
	}

	@GetMapping("/active/customer{id}")
	public List<BookingDto> listActiveBookingsByCustomer(@PathVariable Integer id) {
		List<Booking> customersFound = service.findActiveBookingsByCustomer(id);
		List<BookingDto> customersFoundDTO = customersFound.stream().map(obj -> new BookingDto(obj))
				.collect(Collectors.toList());
		return customersFoundDTO;
	}
	
	@GetMapping("/activebookings")
	public List<Booking> listActiveBookings() {
		Date date = new Date();
		return service.findBookingsBetweenDates(date, date);
	}

	// POST'S ------------------------
	@PostMapping("/add")
	public Booking addNewBooking(@Valid @RequestBody NewBookingDto newBookingDTO) {

		//If id is not provided, it mean's it's a new customer
		if (newBookingDTO.getCustomerId() == null) {
			Customer customer = new Customer(newBookingDTO.getFirstName(), newBookingDTO.getLastName(), 
					newBookingDTO.getAddress(), newBookingDTO.getPhone(), newBookingDTO.getEmail());
			Customer customerSaved = customerService.saveCustomer(customer);

			newBookingDTO.setCustomerId(customerSaved.getCustomerId());
			Booking booking = service.fromDTO(newBookingDTO);
			Booking addBooking = service.saveBooking(booking);
			return addBooking;

		}

		//If id is provided but email is different
		Customer customerId = customerService.customerById(newBookingDTO.getCustomerId());
		if (!customerId.getEmail().equals(newBookingDTO.getEmail())) {
			Customer customer = new Customer(newBookingDTO.getFirstName(), newBookingDTO.getLastName(), 
					newBookingDTO.getAddress(), newBookingDTO.getPhone(), newBookingDTO.getEmail());
			Customer customerSaved = customerService.saveCustomer(customer);

			newBookingDTO.setCustomerId(customerSaved.getCustomerId());
			Booking booking = service.fromDTO(newBookingDTO);
			Booking addBooking = service.saveBooking(booking);
			return addBooking;

		}

		//If is a searched customer
		Booking booking = service.fromDTO(newBookingDTO);
		Booking addBooking = service.saveBooking(booking);
		return addBooking;
	}

	// PUT'S ------------------------
	@PutMapping("/update{id}")
	public Booking updateBooking(@Valid @RequestBody BookingDto updateBookingDTO, @PathVariable Integer id) {
		Booking updateBooking = service.fromDTO(updateBookingDTO);
		updateBooking.setBookingId(id);
		return service.saveBooking(updateBooking);
	}

	// DELETE'S ------------------------
	@DeleteMapping("/delete{id}")
	public void deleteBookingById(@PathVariable Integer id) {
		service.deleteBookingById(id);
	}

}
