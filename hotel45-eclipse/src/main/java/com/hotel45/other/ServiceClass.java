package com.hotel45.other;

import java.util.List;
import java.util.Optional;

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

	public Optional<Customer> customerById(Integer id) {
		Optional<Customer> customer = customerDao.findById(id);
		return customer;
	}

	public List<Booking> findAllBookings() {
		List<Booking> list = bookingDao.findAll();
		return list;
	}

	public Optional<Booking> findBookingById(Integer id) {
		Optional<Booking> booking = bookingDao.findById(id);
		return booking;
	}

	public Booking saveBooking (Booking booking) {
		return bookingDao.save(booking);
	}

	public List<Room> findAllRooms() {
		List<Room> list = roomDao.findAll();
		return list;
	}

	public Optional<Room> roomById(Integer id) {
		Optional<Room> room = roomDao.findById(id);
		return room;
	}
	
	public Room saveRoom(Room room) {
		return roomDao.save(room);
	}

}