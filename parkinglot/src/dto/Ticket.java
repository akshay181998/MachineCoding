package dto;

import java.sql.Timestamp;

public class Ticket {
    private static Integer ticketCounter = 0;
    private Integer ticketId;
    private Timestamp checkInTime;
    private Timestamp checkOutTime;
    private Integer vehicleId;
    private Integer parkingSpotId;
    private Double amount;

    public Integer getTicketId() {
        return ticketId;
    }

    public void setTicketId(Integer ticketId) {
        this.ticketId = ticketId;
    }

    public Integer getParkingSpotId() {
        return parkingSpotId;
    }

    public void setParkingSpotId(Integer parkingSpotId) {
        this.parkingSpotId = parkingSpotId;
    }

    public Timestamp getCheckInTime() {
        return checkInTime;
    }

    public Ticket(Timestamp checkInTime, Timestamp checkOutTime, Integer vehicleId, Double amount, Integer parkingSpotId) {
        this.ticketId = ++ticketCounter;
        this.checkInTime = checkInTime;
        this.checkOutTime = checkOutTime;
        this.vehicleId = vehicleId;
        this.amount = amount;
        this.parkingSpotId = parkingSpotId;
    }

    public void setCheckInTime(Timestamp checkInTime) {
        this.checkInTime = checkInTime;
    }

    public Timestamp getCheckOutTime() {
        return checkOutTime;
    }

    public void setCheckOutTime(Timestamp checkOutTime) {
        this.checkOutTime = checkOutTime;
    }

    public Integer getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Integer vehicleId) {
        this.vehicleId = vehicleId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketId=" + ticketId +
                ", checkInTime=" + checkInTime +
                ", checkOutTime=" + checkOutTime +
                ", vehicleId=" + vehicleId +
                ", amount=" + amount +
                '}';
    }
}
