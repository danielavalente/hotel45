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
<<<<<<< HEAD

	public Optional<Booking> findBookingById(Integer id) {
		Optional<Booking> booking = bookingDao.findById(id);
		return booking;
	}

	public Booking saveBooking (Booking booking) {
		return bookingDao.save(booking);
	}

=======
	
	public List<Customer> findCustomerBySearchTerm(String searchTerm) {
		List<Customer> filterCustomers = customerDao.findBySearchTerm(searchTerm);
		return filterCustomers;		
	}
	
	public List<Booking> findFowardCustomerBookings(Integer id) {
		List<Booking> filterBookings = bookingDao.findFowardCustomerBookings(id, LocalDate.now());
		return filterBookings;
	}
	
	public List<Room> findOccupiedRooms() {
		List<Room> filterRooms = roomDao.findOccupiedRooms();
		return filterRooms;
	}
	
//	public List<Booking> findActiveBookings() {
//		List<Booking> filterBookings = bookingDao.findActiveBookingsCustomerBookings(LocalDate.now());
//		return filterBookings;
//	}
	
	public Room saveRoom(Room room) {
		return roomDao.save(room);
	}
	
	public List<Booking> findAllCustomerBookings(Integer id) {
		List<Booking> filterBookings = bookingDao.findAllCustomerBookings(id);
		return filterBookings;
	}
	
	public Customer findCustomerById(Integer id) {
		Optional<Customer> customer = customerDao.findById(id);
		return customer.orElse(null);
	}
	
>>>>>>> danibranch3
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
