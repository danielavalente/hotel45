package com.hotel45.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel45.controllers.exceptions.DataIntegrityException;
import com.hotel45.dto.RoomDto;
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
	public List<RoomDto> listAllRooms() {
		List<Room> listRooms = service.findAllRooms();
		List<RoomDto> listRoomsDTO = listRooms.stream().map(obj -> new RoomDto(obj)).collect(Collectors.toList());
		return listRoomsDTO;
	}

	@GetMapping("/{id}")
	public RoomDto roomById(@PathVariable Integer id) {
		RoomDto roomDTO = new RoomDto(service.roomById(id));
		return roomDTO;
	}

	@GetMapping("/available")
	public List<RoomDto> findRoomsAvailable() {
		List<Room> rooms = service.findRoomsAvailable();
		List<RoomDto> roomsDTO = rooms.stream().map(obj -> new RoomDto(obj)).collect(Collectors.toList());
		return roomsDTO;
	}

	@GetMapping("/freerooms/{checkInDate}&{checkOutDate}")
	public Set<TypeOfRoom> listFreeRooms(@PathVariable String checkInDate, @PathVariable String checkOutDate) throws ParseException {
		SimpleDateFormat simpledate = new SimpleDateFormat("dd-MM-yyyy");
		Set<TypeOfRoom> freeRooms = service.findFreeRoomsBetweenDates(simpledate.parse(checkInDate),simpledate.parse(checkOutDate));
		
		return freeRooms;
	}
	
	@GetMapping("/freerooms/{checkInDate}&{checkOutDate}/{roomType}")
	public ArrayList<Integer> listFreeRoomsNumber(@PathVariable String checkInDate, @PathVariable String checkOutDate, @PathVariable String roomType) throws ParseException {
		SimpleDateFormat simpledate = new SimpleDateFormat("dd-MM-yyyy");
		ArrayList<Integer> freeRooms = service.findNumberOfFreeRoomsBetweenDates(simpledate.parse(checkInDate),simpledate.parse(checkOutDate), TypeOfRoom.valueOf(roomType));
		
		return freeRooms;
	}

	// POST'S ------------------------
	@PostMapping("/add")
	public Room addRoom(@RequestBody RoomDto roomDTO) {
		Room room = service.fromDTO(roomDTO);
		return service.saveRoom(room);
	}

	// PUT'S ------------------------
	@PutMapping("/update{id}")
	public Room updateRoom(@RequestBody RoomDto updateRoomDTO, @PathVariable Integer id) {
		Room updateRoom = service.fromDTO(updateRoomDTO);
		updateRoom.setId(id);
		return service.saveRoom(updateRoom);
	}

	// DELETE'S ------------------------
	@DeleteMapping("/delete{id}")
	public void deleteRoomById(@PathVariable Integer id) {
		try {
			service.deleteRoomById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("It's not possible to delete a room that has bookings.");
		}
	}

}
