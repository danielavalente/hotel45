package com.hotel45.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import com.hotel45.model.Room;
import com.hotel45.other.StatusClean;
import com.hotel45.other.TypeOfRoom;

public class RoomDto implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer roomId;
	
	@NotNull(message = "This field is mandatory")
	private TypeOfRoom typeOfRoom;
	
	private StatusClean statusClean;
	
	private double costPerDay;
	
	private boolean isAvailable;
	
	public RoomDto() {
		
	}

	public RoomDto(Room room) {
		this.roomId = room.getId();
		this.typeOfRoom = room.getTypeOfRoom();
		this.statusClean = room.getStatusClean();
		this.costPerDay = room.getCostPerDay();
		this.isAvailable = room.getIsAvailable();
	}

	public Integer getId() {
		return roomId;
	}

	public void setId(Integer id) {
		this.roomId = id;
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

	public boolean getIsAvailable() {
		return isAvailable;
	}

	public void setIsAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}	

}
