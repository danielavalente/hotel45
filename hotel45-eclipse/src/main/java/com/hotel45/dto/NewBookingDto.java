package com.hotel45.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

public class NewBookingDto implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer bookingId;
	
	@NotNull(message = "This field is mandatory")
	@JsonFormat(pattern= "dd-MM-yyyy")
	private Date checkInDate;
	
	@NotNull(message = "This field is mandatory")
	@JsonFormat(pattern= "dd-MM-yyyy")
    private Date checkOutDate;
	
    private double totalCost;
    
    private Integer customerId;
    
    @NotNull(message = "This field is mandatory")
	private String firstName;
	
	@NotNull(message = "This field is mandatory")
    private String lastName;
	
	@NotNull(message = "This field is mandatory")
    private String address;
	
	@NotNull(message = "This field is mandatory")
	@Digits(integer=9, fraction=0, message = "This field must be a phone with 9 characters")
    private String phone;
	
	@NotNull(message = "This field is mandatory")
	@Email(message = "This field must be a email")
    private String email;
    
    @NotNull(message = "This field is mandatory")
    private Integer roomId;
    
    
    public NewBookingDto() {
    	
    }

	public NewBookingDto(Integer bookingId, Date checkInDate, Date checkOutDate, double totalCost, Integer customerId,
			String firstName, String lastName, String address, String phone, String email, Integer roomId) {
		this.bookingId = bookingId;
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
		this.totalCost = totalCost;
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.roomId = roomId;
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
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public Integer getBookingId() {
		return bookingId;
	}

	public void setBookingId(Integer id) {
		this.bookingId = id;
	}

	public Date getCheckInDate() {
		return checkInDate;
	}

	public void setCheckInDate(Date checkInDate) {
		this.checkInDate = checkInDate;
	}

	public Date getCheckOutDate() {
		return checkOutDate;
	}

	public void setCheckOutDate(Date checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public Integer getRoomId() {
		return roomId;
	}

	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}	
	
}
