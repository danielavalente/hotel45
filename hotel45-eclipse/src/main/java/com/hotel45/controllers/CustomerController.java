package com.hotel45.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel45.model.Customer;
import com.hotel45.services.CustomerService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/api/customers")
public class CustomerController {

	@Autowired
	private CustomerService service;

	
	//GET'S ------------------------
	@GetMapping(value={"","/"})
	public List<Customer> listCustomers() {
		List<Customer> listCustomers = service.findAllCustomers();
		return listCustomers;
	}

	@GetMapping("/{id}")
	public Customer customerById(@PathVariable Integer id) {
		Customer customer = service.customerById(id);
		return customer;
	}

	@GetMapping("/search={searchTerm}")
	public List<Customer> listCustomerBySearchTerm(@PathVariable String searchTerm) {
		List<Customer> customerFound = service.findCustomerBySearchTerm(searchTerm);
		return customerFound;
	}

	
	//POST'S ------------------------
	@PostMapping("/add")
	public Customer addCustomer(@RequestBody Customer customer) {
		Customer addCustomer = service.saveCustomer(customer);
		return addCustomer;
	}
	
	
	//PUT'S ------------------------
	@PutMapping("/update{id}")
	public Customer updateCustomer(@RequestBody Customer updateCustomer, @PathVariable Integer id) {
		updateCustomer.setId(id);
		return service.saveCustomer(updateCustomer);
	}
	
	
	//DELETE'S ------------------------
	
	

}
