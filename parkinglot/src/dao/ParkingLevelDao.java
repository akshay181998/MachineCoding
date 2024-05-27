package dao;

import dto.ParkingLevel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ParkingLevelDao {
    private final HashMap<Integer, ParkingLevel> parkingLevels;
    private static ParkingLevelDao instance;

    private ParkingLevelDao() {
        this.parkingLevels = new HashMap<>();
    }

    public static synchronized ParkingLevelDao getInstance() {
        if (instance == null) {
            instance = new ParkingLevelDao();
        }
        return instance;
    }

    public List<ParkingLevel> getAllParkingLevel() {
        return new ArrayList<>(this.parkingLevels.values());
    }

    public ParkingLevel getParkingLevel(Integer parkingLevelId) {
        return this.parkingLevels.get(parkingLevelId);
    }

    public void addParkingLevel(Integer parkingLevelId, ParkingLevel parkingLevel) {
        this.parkingLevels.put(parkingLevelId, parkingLevel);
    }

    public  void removeParkingLevel(Integer parkingLevelId) {
        this.parkingLevels.remove(parkingLevelId);
    }
}
