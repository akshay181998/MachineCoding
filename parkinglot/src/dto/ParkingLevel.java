package dto;

import java.util.List;

public class ParkingLevel {
    private Integer parkingLevelId;
    private List<ParkingSpot> parkingSpots;

    public Integer getParkingLevelId() {
        return parkingLevelId;
    }

    public void setParkingLevelId(Integer parkingLevelId) {
        this.parkingLevelId = parkingLevelId;
    }

    public ParkingLevel(Integer parkingLevelId, List<ParkingSpot> parkingSpots) {
        this.parkingLevelId = parkingLevelId;
        this.parkingSpots = parkingSpots;
    }

    public List<ParkingSpot> getParkingSpots() {
        return parkingSpots;
    }

    public void setParkingSpots(List<ParkingSpot> parkingSpots) {
        this.parkingSpots = parkingSpots;
    }
}
