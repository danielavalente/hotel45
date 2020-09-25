package com.hotel45.services;


import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel45.controllers.exceptions.ObjectNotFoundException;
import com.hotel45.dao.RoomDao;
import com.hotel45.model.Room;

@Service
public class RoomService {

	@Autowired
	private RoomDao roomDao;

	// FindAll
	public List<Room> findAllRooms() {
		List<Room> list = roomDao.findAll();
		return list;
	}

	// FindById
	public Room roomById(Integer id) {
		Optional<Room> room = roomDao.findById(id);
		return room.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Room.class.getSimpleName()));
	}

	// Save
	public Room saveRoom(Room room) {
		return roomDao.save(room);
	}

	// Delete
	public void deleteRoomById(Integer id) {
		roomDao.deleteById(id);
	}

	// Others
	public List<Room> findRoomsAvailable() {
		List<Room> filterRooms = roomDao.findRoomsAvailable();
		return filterRooms;
	}

	public List<Room> findRoomsAvailableByDate() {
		List<Room> roomsByDate = roomDao.findAvailableRoomsByDate();
		return roomsByDate;
	}

}
