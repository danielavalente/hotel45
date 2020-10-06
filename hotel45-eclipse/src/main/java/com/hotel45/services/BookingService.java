package com.hotel45.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel45.controllers.exceptions.ObjectNotFoundException;
import com.hotel45.dao.BookingDao;
import com.hotel45.dto.BookingDto;
import com.hotel45.dto.NewBookingDto;
import com.hotel45.model.Booking;

@Service
public class BookingService {

	@Autowired
	private BookingDao bookingDao;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private RoomService roomService;

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
	
	public List<Booking> findBookingsBetweenDates(Date checkInDate, Date checkOutDate) {
		List<Booking> filterBookings = bookingDao.findBookingsBetweenDates(checkInDate, checkOutDate);
		return filterBookings;
	}
	
	//Converter
	public Booking fromDTO(NewBookingDto newBookingDTO) {
		Integer numberOfDays = Math.toIntExact((newBookingDTO.getCheckOutDate().getTime() - newBookingDTO.getCheckInDate().getTime()) / (1000 * 60 * 60 * 24));
		return new Booking(
				customerService.customerById(newBookingDTO.getCustomerId()),
				roomService.roomById(newBookingDTO.getRoomId()),
				newBookingDTO.getCheckInDate(),
				newBookingDTO.getCheckOutDate(),
				roomService.roomById(newBookingDTO.getRoomId()).getCostPerDay() * numberOfDays);
	}
	
	public Booking fromDTO(BookingDto bookingDTO) {
		Integer numberOfDays = Math.toIntExact((bookingDTO.getCheckOutDate().getTime() - bookingDTO.getCheckInDate().getTime()) / (1000 * 60 * 60 * 24));
		return new Booking(
				customerService.customerById(bookingDTO.getCustomerId()),
				roomService.roomById(bookingDTO.getRoomId()),
				bookingDTO.getCheckInDate(),
				bookingDTO.getCheckOutDate(),
				roomService.roomById(bookingDTO.getRoomId()).getCostPerDay() * numberOfDays);
	}
	
}
