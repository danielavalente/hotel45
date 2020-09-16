package org.queuecumbers.hotel45.persistence.model;

public class Room extends AbstractModel{

    private String typeOfRoom;
    private Integer costPerDay;

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
}
