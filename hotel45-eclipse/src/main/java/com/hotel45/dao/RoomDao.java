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
	
	@Query("SELECT room FROM Room room WHERE IS_OCCUPIED = true")
	public List<Room> findOccupiedRooms();

}
