package com.hotel45.dto;

import com.hotel45.other.TypeOfRoom;

public class RoomDto {
	
	private TypeOfRoom typeOfRoom;
	private double costPerDay;
	private boolean isOccupied;
	
	
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
	public boolean isOccupied() {
		return isOccupied;
	}
	public void setOccupied(boolean isOccupied) {
		this.isOccupied = isOccupied;
	}
	
	

}
