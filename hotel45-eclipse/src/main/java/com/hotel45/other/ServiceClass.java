package com.hotel45.other;

import java.time.LocalDate;
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
	
	public List<Customer> findCustomerBySearchTerm(String searchTerm) {
		List<Customer> filterCustomers = customerDao.findBySearchTerm(searchTerm);
		return filterCustomers;		
	}
	
	public List<Booking> findActiveBookingsByCustomer(Integer id) {
		List<Booking> filterBookings = bookingDao.findActiveBookingsByCustomer(id, LocalDate.now());
		return filterBookings;
	}
	
	public List<Room> findOccupiedRooms() {
		List<Room> filterRooms = roomDao.findOccupiedRooms();
		return filterRooms;
	}
	
	public List<Booking> findAllBookingsByCustomer(Integer id) {
		List<Booking> filterBookings = bookingDao.findAllBookingsByCustomer(id);
		return filterBookings;
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
	
	public Customer saveCustomer(Customer customer) {
		customer.setFirstName(customer.getFirstName().toLowerCase());
		customer.setLastName(customer.getLastName().toLowerCase());
		return customerDao.save(customer);
	}
	
	public void deleteBookingById(Integer id) {
		bookingDao.deleteById(id);
	}
	
	
	
	
	
	

}
