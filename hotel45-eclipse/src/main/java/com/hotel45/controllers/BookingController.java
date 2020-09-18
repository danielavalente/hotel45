package com.hotel45.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hotel45.converter.Converter;
import com.hotel45.dto.BookingDto;
import com.hotel45.model.Booking;
import com.hotel45.other.ServiceClass;

@RestController
@RequestMapping(value = "/api")
public class BookingController {

	@Autowired
	private ServiceClass service;

	@RequestMapping(method = RequestMethod.GET, value = "/bookings")
	public ResponseEntity<?> listAllBookings() {
		List<Booking> listBookings = service.findAllBookings();
		return ResponseEntity.ok().body(listBookings);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/bookings/{id}")
	public ResponseEntity<?> listBookingById(@PathVariable Integer id) {
		Optional<Booking> booking = service.findBookingById(id);
		return ResponseEntity.ok().body(booking);
	}
	
	//Adicionar Reservas
	@RequestMapping(method = RequestMethod.POST, value = "/booking/post")
	public ResponseEntity<?> addNewBooking(@RequestBody BookingDto bookingDto) {
				
		Booking newBooking = service.saveBooking(Converter.BookingDtoToBooking(bookingDto));
			
		return ResponseEntity.ok().body(newBooking);
		
	}

}
