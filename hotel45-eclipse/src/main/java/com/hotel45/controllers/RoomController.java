package com.hotel45.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel45.model.Room;
import com.hotel45.other.ServiceClass;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/api")
public class RoomController {

	@Autowired
	private ServiceClass service;

	// Correct Mapping
	@GetMapping("/rooms/occup")
	public List<Room> listOccupiedRooms() {
		List<Room> roomsOccupied = service.findOccupiedRooms();
		return roomsOccupied;
	}

	// Correct Mapping
	@GetMapping("/rooms/{id}")
	public Optional<Room> roomById(@PathVariable Integer id) {
		Optional<Room> room = service.roomById(id);
		return room;
	}

	// Correct Mapping
	@GetMapping("/rooms")
	public List<Room> listAllRooms() {
		List<Room> listRooms = service.findAllRooms();
		return listRooms;
	}

	// Correct Mapping
	@PostMapping("/add-room")
	public Room addRoom(@RequestBody Room room) {
		return service.saveRoom(room);
	}

}
