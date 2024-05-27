package dao;

import dto.ParkingSpot;

import java.util.HashMap;

public class ParkingSpotDao {
    private final HashMap<Integer, ParkingSpot> parkingSpots;
    public static ParkingSpotDao instance;

    private ParkingSpotDao() {
        this.parkingSpots = new HashMap<>();
    }

    public static synchronized ParkingSpotDao getInstance() {
        if(instance == null) {
            instance = new ParkingSpotDao();
        }
        return instance;
    }

    public ParkingSpot getParkingSpot(Integer parkingSpotId) {
        return this.parkingSpots.get(parkingSpotId);
    }

    public void addParkingSpot(Integer parkingSpotId, ParkingSpot parkingSpot) {
        this.parkingSpots.put(parkingSpotId, parkingSpot);
    }

    public void removeParkingSpot(Integer parkingSpotId) {
        this.parkingSpots.remove(parkingSpotId);
    }

    public void updateParkingSpot(Integer parkingSpotId) {
        ParkingSpot parkingSpot = this.parkingSpots.get(parkingSpotId);
        parkingSpot.setAvailable(!parkingSpot.getAvailable());
    }
}
