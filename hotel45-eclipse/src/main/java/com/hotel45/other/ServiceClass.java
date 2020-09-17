package com.hotel45.other;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel45.dao.BookingDao;
import com.hotel45.dao.CustomerDao;
import com.hotel45.dao.RoomDao;
import com.hotel45.model.Booking;
import com.hotel45.model.Customer;
import com.hotel45.model.Room;

@Service
public class ServiceClass {
	
	@Autowired
	private BookingDao bookingDao;
	
	@Autowired
	private CustomerDao customerDao;
	
	@Autowired
	private RoomDao roomDao;
	
	public List<Customer> findAllCustomers() {
		List<Customer> list = customerDao.findAll();
		return list;
	}
	
	public List<Booking> findAllBookings() {
		List<Booking> list = bookingDao.findAll();
		return list;
	}
	
	public List<Room> findAllRooms() {
		List<Room> list = roomDao.findAll();
		return list;
	}
}
