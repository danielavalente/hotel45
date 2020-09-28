package com.hotel45.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hotel45.other.StatusClean;
import com.hotel45.other.TypeOfRoom;

@Entity
@Table(name = "room")
public class Room implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Enumerated(EnumType.STRING)
	private TypeOfRoom typeOfRoom;

	@Enumerated(EnumType.STRING)
	private StatusClean statusClean;

	private double costPerDay;
	private boolean isAvailable;

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "room")
	private List<Booking> bookingList = new ArrayList<>();

	public Room() {

	}

	public Room(TypeOfRoom typeOfRoom, StatusClean statusClean, double costPerDay, boolean isOccupied) {
		super();
		this.statusClean = statusClean;
		this.typeOfRoom = typeOfRoom;
		this.costPerDay = costPerDay;
		this.isAvailable = isOccupied;
	}

	
	public boolean getIsAvailable() {
		return isAvailable;
	}

	public void setIsAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public List<Booking> getBookingList() {
		return bookingList;
	}

	public void setBookingList(List<Booking> bookingList) {
		this.bookingList = bookingList;
	}

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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public StatusClean getStatusClean() {
		return statusClean;
	}

	public void setStatusClean(StatusClean statusClean) {
		this.statusClean = statusClean;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Room other = (Room) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
