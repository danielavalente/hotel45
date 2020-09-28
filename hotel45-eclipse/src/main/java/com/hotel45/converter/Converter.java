package com.hotel45.converter;

import com.hotel45.dto.BookingDto;
import com.hotel45.dto.CustomerDto;
import com.hotel45.dto.RoomDto;
import com.hotel45.model.Booking;
import com.hotel45.model.Customer;
import com.hotel45.model.Room;

public class Converter {

//	public static Customer CustomerDtoToCustomer(CustomerDto customerDto) {
//
//		Customer customer = new Customer();
//
//		customer.setFirstName(customerDto.getFirstName());
//		customer.setLastName(customerDto.getLastName());
//		customer.setPhone(customerDto.getPhone());
//		customer.setAddress(customerDto.getAddress());
//		customer.setEmail(customerDto.getEmail());
//
//		return customer;
//
//	}
//
//	public static CustomerDto CustomerToCustomerDto(Customer customer) {
//
//		CustomerDto customerDto = new CustomerDto();
//
//		customerDto.setFirstName(customer.getFirstName());
//		customerDto.setLastName(customer.getLastName());
//		customerDto.setEmail(customer.getEmail());
//		customerDto.setPhone(customer.getPhone());
//		customerDto.setAddress(customer.getAddress());
//
//		return customerDto;
//
//	}
//
//	public static Booking BookingDtoToBooking(BookingDto bookingDto) {
//
//		Booking booking = new Booking();
//
//		booking.setCheckInDate(bookingDto.getCheckInDate());
//		booking.setCheckOutDate(bookingDto.getCheckOutDate());
//		booking.setTotalCost(bookingDto.getTotalCost());
//
//		return booking;
//
//	}
//
//	public static BookingDto BookingToBookingDto(Booking booking) {
//
//		BookingDto bookingDto = new BookingDto();
//
//		booking.setCheckInDate(booking.getCheckInDate());
//		booking.setCheckOutDate(booking.getCheckOutDate());
//		booking.setTotalCost(booking.getTotalCost());
//
//		return bookingDto;
//
//	}
//
//	public static Room RoomDtoToRoom(RoomDto roomDto) {
//
//		Room room = new Room();
//
//		room.setAvailable(roomDto.isAvailable());
//		room.setCostPerDay(roomDto.getCostPerDay());
//		room.setTypeOfRoom(roomDto.getTypeOfRoom());
//
//		return room;
//
//	}
//
//	public static RoomDto RoomToRoomDto(Room room) {
//
//		RoomDto roomDto = new RoomDto();
//
//		roomDto.setAvailable(room.isAvailable());
//		roomDto.setCostPerDay(roomDto.getCostPerDay());
//		roomDto.setTypeOfRoom(roomDto.getTypeOfRoom());
//
//		return roomDto;
//
//	}

}
