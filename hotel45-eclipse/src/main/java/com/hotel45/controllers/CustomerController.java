package com.hotel45.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hotel45.model.Booking;
import com.hotel45.model.Customer;
import com.hotel45.model.Room;
import com.hotel45.other.ServiceClass;

@RestController
@RequestMapping(value = "/api")
public class CustomerController {
	
	@Autowired
	private ServiceClass service;

		@RequestMapping(method=RequestMethod.GET, value = "/customers")
		public ResponseEntity<?> listAllCustomers() {
			List<Customer> listCustomers = service.findAllCustomers();
			return ResponseEntity.ok().body(listCustomers);
		}
		
		
		@RequestMapping(method=RequestMethod.GET, value = "/rooms")
		public ResponseEntity<?> listAllRooms() {
			List<Room> listRooms = service.findAllRooms();
			return ResponseEntity.ok().body(listRooms);
		}
		
		@RequestMapping(method=RequestMethod.GET, value = "/bookings")
		public ResponseEntity<?> listAllBookings() {
			List<Booking> listBookings = service.findAllBookings();
			return ResponseEntity.ok().body(listBookings);
		}
}
