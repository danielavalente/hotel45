package com.hotel45.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hotel45.model.Booking;


@Repository
@Transactional
public interface BookingDao extends JpaRepository<Booking, Integer> {
	
	@Query("SELECT booking FROM Booking booking WHERE customer.id = :id")
	public List<Booking> findAllBookingsByCustomer(@Param("id") Integer id);
	
	@Query("SELECT booking FROM Booking booking WHERE customer.id = :id AND booking.checkOutDate > :datenow")
	public List<Booking> findActiveBookingsByCustomer(@Param("id") Integer id, @Param("datenow") Date datenow);
	
<<<<<<< HEAD
	@Query("SELECT booking FROM Booking booking WHERE booking.checkInDate < '2020-09-26' AND booking.checkOutDate > '2020-09-19'")
	public List<Booking> findBookingsBetweenDates();
	
	
=======
//	@Query("SELECT booking FROM Booking booking WHERE booking.checkOutDate > :datenow AND booking.checkInDate < :datenow")
//	public List<Booking> findActiveBookingsCustomerBookings(@Param("datenow") LocalDate datenow);
	
	

>>>>>>> CleanningSystem
}
