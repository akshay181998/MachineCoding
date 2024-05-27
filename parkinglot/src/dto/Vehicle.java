package dto;

import enums.VehicleType;

public class Vehicle {
    private  static Integer vehicleCounter = 0;
    private Integer vehicleId;
    private VehicleType vehicleType;
    private String vehicleNumber;
    String[] VehicleNumbers = new String[]{"MP08XM2142", "KA08XM2142", "DL08XM2142"};


    public Vehicle(VehicleType vehicleType) {
        this.vehicleId = ++vehicleCounter;
        this.vehicleType = vehicleType;
        this.vehicleNumber = VehicleNumbers[vehicleCounter%3];
    }

    public Integer getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Integer vehicleId) {
        this.vehicleId = vehicleId;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicleId=" + vehicleId +
                ", vehicleType=" + vehicleType +
                ", vehicleNumber='" + vehicleNumber + '\'' +
                '}';
    }
}
