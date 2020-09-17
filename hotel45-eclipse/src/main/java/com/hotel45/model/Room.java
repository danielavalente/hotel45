package com.hotel45.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name = "room")
public class Room implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	
    private String typeOfRoom;
    private Integer costPerDay;
    
    public Room() {
    	
    }

    public Room(Integer id, String typeOfRoom, Integer costPerDay, List<Booking> bookingList) {
		super();
		this.id = id;
		this.typeOfRoom = typeOfRoom;
		this.costPerDay = costPerDay;
		this.bookingList = bookingList;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "room")
    private List<Booking> bookingList;

    public String getTypeOfRoom() {
        return typeOfRoom;
    }

    public void setTypeOfRoom(String typeOfRoom) {
        this.typeOfRoom = typeOfRoom;
    }

    public Integer getCostPerDay() {
        return costPerDay;
    }

    public void setCostPerDay(Integer costPerDay) {
        this.costPerDay = costPerDay;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
