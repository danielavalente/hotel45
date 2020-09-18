package com.hotel45.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hotel45.converter.Converter;
import com.hotel45.dto.RoomDto;
import com.hotel45.model.Room;
import com.hotel45.other.ServiceClass;

@RestController
@RequestMapping(value = "/api")
public class RoomController {

	@Autowired
	private ServiceClass service;

	@RequestMapping(method = RequestMethod.GET, value = "/rooms")
	public ResponseEntity<?> listAllRooms() {
		List<Room> listRooms = service.findAllRooms();
		return ResponseEntity.ok().body(listRooms);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/rooms/{id}")
	public ResponseEntity<?> roomById(@PathVariable Integer id) {
		Optional<Room> room = service.roomById(id);
		return ResponseEntity.ok().body(room);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/rooms/post")
	public ResponseEntity<?> addNewRoom(@RequestBody RoomDto roomDto) {
		Room room = service.saveRoom(Converter.RoomDtoToRoom(roomDto));
		return ResponseEntity.ok().body(room);
	}

}