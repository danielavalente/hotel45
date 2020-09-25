package com.hotel45.controllers;

<<<<<<< HEAD
import java.util.ArrayList;
=======
import java.util.Date;
>>>>>>> CleanningSystem
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel45.model.Room;
import com.hotel45.other.TypeOfRoom;
import com.hotel45.services.RoomService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/api/rooms")
public class RoomController {

	@Autowired
	private RoomService service;

	// GET'S ------------------------
	@GetMapping(value = { "", "/" })
	public List<Room> listAllRooms() {
		List<Room> listRooms = service.findAllRooms();
		return listRooms;
	}

	@GetMapping("/{id}")
	public Room roomById(@PathVariable Integer id) {
		Room room = service.roomById(id);
		return room;
	}

	@GetMapping("/available")
	public List<Room> findRoomsAvailable() {
		List<Room> rooms = service.findRoomsAvailable();
		return rooms;
	}

	@GetMapping("/checkin")
	public List<Room> findRoomsAvailableByDate() {
		List<Room> rooms = service.findRoomsAvailableByDate();
		return rooms;
	}
<<<<<<< HEAD
	
	@GetMapping("/freeRooms")
	public Set<TypeOfRoom> listFreeRooms() {
		Set<TypeOfRoom> freeRooms = service.findFreeRoomsBetweenDates();
		return freeRooms;
	}
	
=======
>>>>>>> CleanningSystem

	// POST'S ------------------------
	@PostMapping("/add")
	public Room addRoom(@RequestBody Room room) {
		return service.saveRoom(room);
	}

	// PUT'S ------------------------
	@PutMapping("/update{id}")
	public Room updateRoom(@RequestBody Room updateRoom, @PathVariable Integer id) {
		updateRoom.setId(id);
		return service.saveRoom(updateRoom);
	}

	// DELETE'S ------------------------
	@DeleteMapping("/delete{id}")
	public void deleteRoomById(@PathVariable Integer id) {
		service.deleteRoomById(id);
	}

}
