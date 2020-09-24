package com.hotel45.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel45.controllers.exceptions.ObjectNotFoundException;
import com.hotel45.dao.BookingDao;
import com.hotel45.model.Booking;

@Service
public class BookingService {

	@Autowired
	private BookingDao bookingDao;

	//FindAll
	public List<Booking> findAllBookings() {
		List<Booking> list = bookingDao.findAll();
		return list;
	}

	//FindById
	public Booking findBookingById(Integer id) {
		Optional<Booking> booking = bookingDao.findById(id);
		return booking.orElseThrow(() -> new ObjectNotFoundException(
				 "Objeto não encontrado! Id: " + id + ", Tipo: " + Booking.class.getSimpleName()));
	}

	//Save
	public Booking saveBooking (Booking booking) {
		return bookingDao.save(booking);
	}
	
	//Delete
	public void deleteBooking(Booking booking) {
		bookingDao.delete(booking);
	}
	
	public void deleteBookingById(Integer id) {
		bookingDao.deleteById(id);
	}
	
	
	//Others
	public List<Booking> findActiveBookingsByCustomer(Integer id) {
		Date date = new Date();
		List<Booking> filterBookings = bookingDao.findActiveBookingsByCustomer(id, date);
		return filterBookings;
	}
	
	public List<Booking> findAllBookingsByCustomer(Integer id) {
		List<Booking> filterBookings = bookingDao.findAllBookingsByCustomer(id);
		return filterBookings;
	}
	
	public List<Booking> findBookingsBetweenDates() {
		List<Booking> filterBookings = bookingDao.findBookingsBetweenDates();
		return filterBookings;
	}
	
}
