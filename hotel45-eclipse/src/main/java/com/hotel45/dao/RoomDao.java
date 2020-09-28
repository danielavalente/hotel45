package com.hotel45.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hotel45.model.Room;

@Repository
@Transactional
public interface RoomDao extends JpaRepository<Room, Integer> {
	
	@Query("SELECT room FROM Room room WHERE IS_AVAILABLE = true")
	public List<Room> findRoomsAvailable();
	
	@Query("SELECT room.id FROM Room room WHERE room.id = 1")
	public List<Room> findAvailableRoomsByDate();
	
	//NOT IN (SELECT booking.room_id FROM Booking booking WHERE booking.check_in_date < :checkOutDate AND booking.check_out_date > :checkInDate)
	//@Param("checkInDate") Date checkInDate, @Param("checkOutDate")Date checkOutDate
}
