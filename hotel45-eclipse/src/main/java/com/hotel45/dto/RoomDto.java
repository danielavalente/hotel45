package com.hotel45.dto;

import java.io.Serializable;

import com.hotel45.model.Room;
import com.hotel45.other.StatusClean;
import com.hotel45.other.TypeOfRoom;

public class RoomDto implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private TypeOfRoom typeOfRoom;
	private StatusClean statusClean;
	private double costPerDay;
	private boolean isAvailable;
	
	public RoomDto() {
		
	}

	public RoomDto(Room room) {
		this.id = room.getId();
		this.typeOfRoom = room.getTypeOfRoom();
		this.statusClean = room.getStatusClean();
		this.costPerDay = room.getCostPerDay();
		this.isAvailable = room.getIsAvailable();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public TypeOfRoom getTypeOfRoom() {
		return typeOfRoom;
	}

	public void setTypeOfRoom(TypeOfRoom typeOfRoom) {
		this.typeOfRoom = typeOfRoom;
	}

	public StatusClean getStatusClean() {
		return statusClean;
	}

	public void setStatusClean(StatusClean statusClean) {
		this.statusClean = statusClean;
	}

	public double getCostPerDay() {
		return costPerDay;
	}

	public void setCostPerDay(double costPerDay) {
		this.costPerDay = costPerDay;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}	

}
