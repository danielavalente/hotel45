package com.hotel45.services;


import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;


import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel45.controllers.exceptions.ObjectNotFoundException;
import com.hotel45.dao.BookingDao;
import com.hotel45.dao.RoomDao;
import com.hotel45.dto.RoomDto;
import com.hotel45.model.Booking;
import com.hotel45.model.Room;
import com.hotel45.other.TypeOfRoom;

@Service
public class RoomService {

	@Autowired
	private RoomDao roomDao;

	
	@Autowired
	private BookingDao bookingDao;
	


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

	
	public Set<TypeOfRoom> findFreeRoomsBetweenDates (Date checkInDate, Date checkOutDate) {
		List<Room> allRooms = roomDao.findAll();
		List<Booking> allBookingsbetweenDates = bookingDao.findBookingsBetweenDates(checkInDate,checkOutDate);
		
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

	}
	
	public ArrayList<Integer> findNumberOfFreeRoomsBetweenDates (Date checkInDate, Date checkOutDate, TypeOfRoom roomType) {
		List<Room> allRoomsByType = roomDao.findRoomsByType(roomType);
		List<Booking> allBookingsbetweenDates = bookingDao.findBookingsBetweenDates(checkInDate,checkOutDate);
		
		ArrayList<Integer> allRoomsIds = new ArrayList<>();
		for (Room room : allRoomsByType) {
			allRoomsIds.add(room.getId());
		}
		
		ArrayList<Integer> allBookingsbetweenDatesRoomId = new ArrayList<>();
		for (Booking booking : allBookingsbetweenDates) {
			allBookingsbetweenDatesRoomId.add(booking.getRoom().getId());
		}
		
		allRoomsIds.removeAll(allBookingsbetweenDatesRoomId);
		
		return allRoomsIds;

	}
	
	//Converter
	public Room fromDTO (RoomDto roomDTO) {
		return new Room(
				roomDTO.getTypeOfRoom(),
				roomDTO.getStatusClean(),
				roomDTO.getCostPerDay(),
				roomDTO.getIsAvailable());
	}

}
