package com.hotel45.dto;

import java.io.Serializable;

import com.hotel45.model.Customer;

public class CustomerDto implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String firstName;
    private String lastName;
    private String Address;
    private String phone;
    private String email;
   
	public CustomerDto() {
		
	}

	public CustomerDto(Customer customer) {
		this.id = customer.getId();
		this.firstName = customer.getFirstName();
		this.lastName = customer.getLastName();
		Address = customer.getAddress();
		this.phone = customer.getPhone();
		this.email = customer.getEmail();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	

}
