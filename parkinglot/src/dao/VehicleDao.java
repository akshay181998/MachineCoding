package dao;

import dto.Vehicle;

import java.util.HashMap;

public class VehicleDao {
    private final HashMap<Integer, Vehicle> Vehicles;
    public static VehicleDao instance;

    private VehicleDao() {
        this.Vehicles = new HashMap<>();
    }

    public static synchronized VehicleDao getInstance() {
        if(instance == null) {
            instance = new VehicleDao();
        }
        return instance;
    }

    public Vehicle getVehicle(Integer VehicleId) {
        return this.Vehicles.get(VehicleId);
    }

    public void addVehicle(Integer VehicleId, Vehicle Vehicle) {
        this.Vehicles.put(VehicleId, Vehicle);
    }

    public void removeVehicle(Integer VehicleId) {
        this.Vehicles.remove(VehicleId);
    }
}
