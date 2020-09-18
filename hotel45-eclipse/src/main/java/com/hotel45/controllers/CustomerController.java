package com.hotel45.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hotel45.model.Customer;
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
		public ResponseEntity<?> roomById(@PathVariable Integer id) {
			Optional<Customer> customer = service.customerById(id);
			return ResponseEntity.ok().body(customer);
		}
}
