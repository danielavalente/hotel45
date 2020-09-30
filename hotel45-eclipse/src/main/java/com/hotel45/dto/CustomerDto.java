package com.hotel45.dto;

import java.io.Serializable;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import com.hotel45.model.Customer;

public class CustomerDto implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer customerId;
	
	@NotNull(message = "This field is mandatory")
	private String firstName;
	
	@NotNull(message = "This field is mandatory")
    private String lastName;
	
	@NotNull(message = "This field is mandatory")
    private String Address;
	
	@NotNull(message = "This field is mandatory")
	@Digits(integer=9, fraction=0, message = "This field must be a phone with 9 characters")
    private String phone;
	
	@NotNull(message = "This field is mandatory")
	@Email(message = "This field must be a email")
    private String email;
   
	public CustomerDto() {
		
	}

	public CustomerDto(Customer customer) {
		this.customerId = customer.getCustomerId();
		this.firstName = customer.getFirstName();
		this.lastName = customer.getLastName();
		Address = customer.getAddress();
		this.phone = customer.getPhone();
		this.email = customer.getEmail();
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer id) {
		this.customerId = id;
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
