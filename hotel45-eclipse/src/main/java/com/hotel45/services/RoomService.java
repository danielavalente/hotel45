package com.hotel45.services;

<<<<<<< HEAD
import java.util.ArrayList;
import java.util.HashSet;
=======

import java.util.Date;
>>>>>>> CleanningSystem
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel45.controllers.exceptions.ObjectNotFoundException;
import com.hotel45.dao.BookingDao;
import com.hotel45.dao.RoomDao;
import com.hotel45.model.Booking;
import com.hotel45.model.Room;
import com.hotel45.other.TypeOfRoom;

@Service
public class RoomService {

	@Autowired
	private RoomDao roomDao;
<<<<<<< HEAD
	
	@Autowired
	private BookingDao bookingDao;
	
	//FindAll
=======

	// FindAll
>>>>>>> CleanningSystem
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
<<<<<<< HEAD
	
	public Set<TypeOfRoom> findFreeRoomsBetweenDates () {
		List<Room> allRooms = roomDao.findAll();
		List<Booking> allBookingsbetweenDates = bookingDao.findBookingsBetweenDates();
		
		ArrayList<Integer> allRoomsIds = new ArrayList<>();
		for (Room room : allRooms) {
			allRoomsIds.add(room.getId());
		}
		
		ArrayList<Integer> allBookingsbetweenDatesRoomId = new ArrayList<>();
		for (Booking booking : allBookingsbetweenDates) {
			allBookingsbetweenDatesRoomId.add(booking.getRoom().getId());
		}
		
		allRoomsIds.removeAll(allBookingsbetweenDatesRoomId);
		
		Set<TypeOfRoom> distinctAvailableRoomType = new HashSet<>();
		for (Integer id : allRoomsIds) {
			distinctAvailableRoomType.add(roomById(id).getTypeOfRoom());
		}
		
		return distinctAvailableRoomType;
=======

	public List<Room> findRoomsAvailableByDate() {
		List<Room> roomsByDate = roomDao.findAvailableRoomsByDate();
		return roomsByDate;
>>>>>>> CleanningSystem
	}

}
