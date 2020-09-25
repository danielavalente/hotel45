package com.hotel45.dto;

import com.hotel45.other.TypeOfRoom;

public class RoomDto {
	
	private TypeOfRoom typeOfRoom;
	private double costPerDay;
	private boolean isAvailable;
	
	
	public TypeOfRoom getTypeOfRoom() {
		return typeOfRoom;
	}
	public void setTypeOfRoom(TypeOfRoom typeOfRoom) {
		this.typeOfRoom = typeOfRoom;
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
	public void setAvailable(boolean isOccupied) {
		this.isAvailable = isOccupied;
	}
	
	

}
