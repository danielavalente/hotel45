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

import com.hotel45.dto.CustomerDto;
import com.hotel45.model.Customer;
import com.hotel45.services.CustomerService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/api/customers")
public class CustomerController {

	@Autowired
	private CustomerService service;

	// GET'S ------------------------
	@GetMapping(value = { "", "/" })
	public List<CustomerDto> listCustomers() {
		List<Customer> listCustomers = service.findAllCustomers();
		List<CustomerDto> listCustomersDTO = listCustomers.stream().map(obj -> new CustomerDto(obj)).collect(Collectors.toList());
		return listCustomersDTO;
	}

	@GetMapping("/{id}")
	public CustomerDto customerById(@PathVariable Integer id) {
		CustomerDto customerDTO = new CustomerDto(service.customerById(id));
		return customerDTO;
	}

	@GetMapping("/search={searchTerm}")
	public List<CustomerDto> listCustomerBySearchTerm(@PathVariable String searchTerm) {
		List<Customer> customerFound = service.findCustomerBySearchTerm(searchTerm);
		List<CustomerDto> customerFoundDTO = customerFound.stream().map(obj -> new CustomerDto(obj)).collect(Collectors.toList());
		return customerFoundDTO;
	}

	// POST'S ------------------------
	@PostMapping("/add")
	public Customer addCustomer(@Valid @RequestBody CustomerDto customerDTO) {
		Customer customer = service.fromDTO(customerDTO);
		Customer addCustomer = service.saveCustomer(customer);
		return addCustomer;
	}

	// PUT'S ------------------------
	@PutMapping("/update{id}")
	public Customer updateCustomer(@RequestBody CustomerDto updateCustomerDTO, @PathVariable Integer id) {
		Customer updateCustomer = service.fromDTO(updateCustomerDTO);
		updateCustomer.setId(id);
		return service.saveCustomer(updateCustomer);
	}

	// DELETE'S ------------------------
	@DeleteMapping("/delete{id}")
	public void deleteCustomerById(@PathVariable Integer id) {
		service.deleteCustomerById(id);
	}

}
