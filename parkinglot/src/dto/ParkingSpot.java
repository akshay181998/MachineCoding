package dto;

import enums.ParkingSpotType;

public class ParkingSpot {
    private Integer parkingSpotId;
    private ParkingSpotType parkingSpotType;
    private Double parkingCharges;
    private Boolean available;

    @Override
    public String toString() {
        return "ParkingSpot{" +
                "parkingSpotId=" + parkingSpotId +
                ", parkingSpotType=" + parkingSpotType +
                ", parkingCharges=" + parkingCharges +
                ", available=" + available +
                '}';
    }

    public Integer getParkingSpotId() {
        return parkingSpotId;
    }

    public ParkingSpot(Integer parkingSpotId, ParkingSpotType parkingSpotType, Double parkingCharges, Boolean available) {
        this.parkingSpotId = parkingSpotId;
        this.parkingSpotType = parkingSpotType;
        this.parkingCharges = parkingCharges;
        this.available = available;
    }

    public void setParkingSpotId(Integer parkingSpotId) {
        this.parkingSpotId = parkingSpotId;
    }

    public ParkingSpotType getParkingSpotType() {
        return parkingSpotType;
    }

    public void setParkingSpotType(ParkingSpotType parkingSpotType) {
        this.parkingSpotType = parkingSpotType;
    }

    public Double getParkingCharges() {
        return parkingCharges;
    }

    public void setParkingCharges(Double parkingCharges) {
        this.parkingCharges = parkingCharges;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }
}
