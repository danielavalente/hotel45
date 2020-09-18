package com.hotel45.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
		
		@RequestMapping(method=RequestMethod.GET, value = "/customers/{id}")
		public ResponseEntity<?> listCustomer(@PathVariable Integer id) {
			Customer customer = service.findCustomerById(id);
			return ResponseEntity.ok().body(customer);
		}
		
		@RequestMapping(method=RequestMethod.GET, value = "/customers/search={searchTerm}")
		public ResponseEntity<?> listCustomer(@PathVariable String searchTerm) {
			List<Customer> customersFound = service.findCustomerBySearchTerm(searchTerm);
			return ResponseEntity.ok().body(customersFound);
		}
		
		@RequestMapping(method=RequestMethod.GET, value = "/rooms/occup")
		public ResponseEntity<?> listOccupiedRooms() {
			List<Room> roomsOccupied = service.findOccupiedRooms();
			return ResponseEntity.ok().body(roomsOccupied);
		}
		
		@RequestMapping(method=RequestMethod.GET, value = "/customers/bookings={id}")
		public ResponseEntity<?> listAllClientBookings(@PathVariable Integer id) {
			List<Booking> customersFound = service.findAllCustomerBookings(id);
			return ResponseEntity.ok().body(customersFound);
		}
		
//		@RequestMapping(method=RequestMethod.GET, value = "/bookings/active")
//		public ResponseEntity<?> listActiveBookings() {
//			List<Booking> activeBookings = service.findActiveBookings();
//			return ResponseEntity.ok().body(activeBookings);
//		}
		
		@PostMapping("/add-room")
		public Room addRoom(@RequestBody Room room) {
			return service.saveRoom(room);
		}
		
		
		
		@RequestMapping(method=RequestMethod.GET, value = "/customers/bookingsfoward={id}")
		public ResponseEntity<?> listFowardClientBookings(@PathVariable Integer id) {
			List<Booking> customersFound = service.findFowardCustomerBookings(id);
			return ResponseEntity.ok().body(customersFound);
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
