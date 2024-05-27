package service;

import dto.Customer;
import dto.ParkingSpot;

import java.util.List;

public interface ParkingService {
    List<ParkingSpot> availableParkingSpots();
    void allotParkingSpot(Customer customer, ParkingSpot parkingSpot);
    void releaseParkingSpot(Integer ticketId);
}
