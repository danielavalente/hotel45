package com.hotel45.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel45.model.Booking;
import com.hotel45.other.ServiceClass;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/api/bookings")
public class BookingController {

	@Autowired
	private ServiceClass service;

	@GetMapping("/")
	public List<Booking> listBookings() {
		List<Booking> listBookings = service.findAllBookings();
		return listBookings;
	}

	@GetMapping("/{id}")
	public Optional<Booking> listBookingById(@PathVariable Integer id) {
		Optional<Booking> booking = service.findBookingById(id);
		return booking;
	}

	@PostMapping("/add")
	public Booking addNewBooking(@RequestBody Booking booking) {
		Booking addBooking = service.saveBooking(booking);
		return addBooking;
	}

	@GetMapping("/customer{id}")
	public List<Booking> listAllBookingsByCustomer(@PathVariable Integer id) {
		List<Booking> customersFound = service.findAllBookingsByCustomer(id);
		return customersFound;
	}

	@GetMapping("/active/customer{id}")
	public List<Booking> findActiveBookingsByCustomer(@PathVariable Integer id) {
		List<Booking> customersFound = service.findActiveBookingsByCustomer(id);
		return customersFound;
	}

	@DeleteMapping("/delete{id}")
	public void deleteBookingById(@PathVariable Integer id) {
		service.deleteBookingById(id);
		System.out.println("nuno correct bugs");
	}

}
