package com.hotel45.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hotel45.model.Booking;

public class BookingDto implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	@JsonFormat(pattern= "dd/MM/yyyy")
	private Date checkInDate;
	
	@JsonFormat(pattern= "dd/MM/yyyy")
    private Date checkOutDate;
	
    private double totalCost;
    private Integer customerId;
    private Integer roomId;
    
    public BookingDto() {
    	
    }

	public BookingDto(Booking booking) {
		this.id = booking.getId();
		this.checkInDate = booking.getCheckInDate();
		this.checkOutDate = booking.getCheckOutDate();
		this.totalCost = booking.getTotalCost();
		this.customerId = new CustomerDto(booking.getCustomer()).getId();
		this.roomId = new RoomDto(booking.getRoom()).getId();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
