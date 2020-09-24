package com.hotel45.controllers;

import java.util.List;

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
	public List<Booking> listBookings() {
		List<Booking> listBookings = service.findAllBookings();
		return listBookings;
	}

	@GetMapping("/{id}")
	public Booking listBookingById(@PathVariable Integer id) {
		Booking booking = service.findBookingById(id);
		return booking;
	}

	@GetMapping("/customer{id}")
	public List<Booking> listAllBookingsByCustomer(@PathVariable Integer id) {
		List<Booking> customersFound = service.findAllBookingsByCustomer(id);
		return customersFound;
	}

	@GetMapping("/active/customer{id}")
	public List<Booking> listActiveBookingsByCustomer(@PathVariable Integer id) {
		List<Booking> customersFound = service.findActiveBookingsByCustomer(id);
		return customersFound;
	}

	
	//POST'S ------------------------
	@PostMapping("/add")
	public Booking addNewBooking(@RequestBody Booking booking) {
		Booking addBooking = service.saveBooking(booking);
		return addBooking;
	}
	
	
	//PUT'S ------------------------
	@PutMapping("/update{id}")
	public Booking updateBooking(@RequestBody Booking updateBooking, @PathVariable Integer id) {
		updateBooking.setId(id);
		return service.saveBooking(updateBooking);
	}
	
	
	//DELETE'S ------------------------
	@DeleteMapping("/delete{id}")
	public void deleteBookingById(@PathVariable Integer id) {
		service.deleteBookingById(id);
	}

}
