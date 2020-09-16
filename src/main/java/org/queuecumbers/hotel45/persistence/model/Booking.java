package org.queuecumbers.hotel45.persistence.model;

import java.util.Date;

public class Booking extends AbstractModel {

    private Integer Customer_id;
    private Integer room_id;
    private Date checkInDate;
    private Date checkOutDate;
    private double totalCost;

    public Integer getCustomer_id() {
        return Customer_id;
    }

    public void setCustomer_id(Integer customer_id) {
        Customer_id = customer_id;
    }

    public Integer getRoom_id() {
        return room_id;
    }

    public void setRoom_id(Integer room_id) {
        this.room_id = room_id;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "Customer_id=" + Customer_id +
                ", room_id=" + room_id +
                ", checkInDate=" + checkInDate +
                ", checkOutDate=" + checkOutDate +
                ", totalCost=" + totalCost +
                '}';
    }
}
