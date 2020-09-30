package com.hotel45.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hotel45.model.Room;
import com.hotel45.other.TypeOfRoom;

@Repository
@Transactional
public interface RoomDao extends JpaRepository<Room, Integer> {
	
	@Query("SELECT room FROM Room room WHERE IS_AVAILABLE = true")
	public List<Room> findRoomsAvailable();
	
	@Query("SELECT room FROM Room room WHERE room.typeOfRoom = :roomType")
	public List<Room> findRoomsByType(@Param("roomType") TypeOfRoom roomType);
}
