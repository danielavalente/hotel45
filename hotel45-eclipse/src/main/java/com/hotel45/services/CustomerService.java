package com.hotel45.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel45.controllers.exceptions.ObjectNotFoundException;
import com.hotel45.dao.CustomerDao;
import com.hotel45.model.Customer;

@Service
public class CustomerService {

	@Autowired
	private CustomerDao customerDao;
	
	//FindAll
	public List<Customer> findAllCustomers() {
		List<Customer> list = customerDao.findAll();
		return list;
	}

	//FindById
	public Customer customerById(Integer id) {
		Optional<Customer> customer = customerDao.findById(id);
		return customer.orElseThrow(() -> new ObjectNotFoundException(
				 "Objeto não encontrado! Id: " + id + ", Tipo: " + Customer.class.getSimpleName()));
	}
	
	//Save
	public Customer saveCustomer(Customer customer) {
		return customerDao.save(customer);
	}
	
	//Delete
	public void deleteCustomerById(Integer id) {
		customerDao.deleteById(id);
	}

	
	//Others
	public List<Customer> findCustomerBySearchTerm(String searchTerm) {
		List<Customer> filterCustomers = customerDao.findBySearchTerm(searchTerm);
		return filterCustomers;		
	}

	

}
