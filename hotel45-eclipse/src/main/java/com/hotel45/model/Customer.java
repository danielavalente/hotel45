package com.hotel45.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table (name = "customer")
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customerId;
	
	private String firstName;
    private String lastName;
    private String Address;
    private String phone;
    private String email;
    
    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer",cascade = CascadeType.ALL)
	private List<Booking> bookingList = new ArrayList<>();
    
    public Customer()  {
    	
    }
    
	public Customer(String firstName, String lastName, String address, String phone, String email) {
		super();
		this.firstName = firstName.toLowerCase();
		this.lastName = lastName.toLowerCase();
		this.Address = address;
		this.phone = phone;
		this.email = email;
	}
	
	public List<Booking> getBookingList() {
		return bookingList;
	}

	public void setBookingList(List<Booking> bookingList) {
		this.bookingList = bookingList;
	}

	public String getFirstName() {
		return firstName.substring(0, 1).toUpperCase() + firstName.substring(1);
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName.toLowerCase();
	}
	
	public String getLastName() {
		return lastName.substring(0, 1).toUpperCase() + lastName.substring(1);
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName.toLowerCase();
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
	
	public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer id) {
        this.customerId = id;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customerId == null) ? 0 : customerId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (customerId == null) {
			if (other.customerId != null)
				return false;
		} else if (!customerId.equals(other.customerId))
			return false;
		return true;
	}
    
    
    
}
