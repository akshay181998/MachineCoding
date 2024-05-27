import dao.*;
import dto.*;
import enums.ParkingSpotType;
import enums.VehicleType;
import service.ParkingService;
import service.impl.ParkingServiceImpl;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        generateParkingSpotsAndParkingLevel();
        displayParkingInfo();
        System.out.println("---------------------");
        generateCustomerAndBookTicket();
        displayParkingInfo();
        System.out.println("---------------------");
        generateCustomerAndBookTicket();
        displayParkingInfo();
        generateCustomerAndBookTicket();
        System.out.println("---------------------");
        displayParkingInfo();
        releaseParkingSpot();
        System.out.println("---------------------");
        displayParkingInfo();
    }

    private static void releaseParkingSpot() {
        ParkingService parkingService = new ParkingServiceImpl();
        parkingService.releaseParkingSpot(1);
        displayTicketInformation(1);
    }

    private static void generateCustomerAndBookTicket() {
        VehicleDao vehicleDao = VehicleDao.getInstance();
        Vehicle vehicle = new Vehicle(VehicleType.SUV);
        vehicleDao.addVehicle(vehicle.getVehicleId(), vehicle);
        Customer customer = new Customer("Ramesh", vehicle.getVehicleId());
        ParkingService parkingService = new ParkingServiceImpl();
        List<ParkingSpot> parkingSpots = parkingService.availableParkingSpots();
        if (!parkingSpots.isEmpty()) {
            parkingService.allotParkingSpot(customer, parkingSpots.get(0));
            displayTicketInformation(customer.getTicketId());
        }
    }

    private static void generateParkingSpotsAndParkingLevel() {
        ParkingSpot parkingSpot;
        ParkingLevel parkingLevel;
        ParkingSpotDao parkingSpotDao = ParkingSpotDao.getInstance();
        ParkingLevelDao parkingLevelDao = ParkingLevelDao.getInstance();
        List<ParkingSpot> parkingSpotList = new ArrayList<>();
        for(int i = 0 ; i < 3 ; i++) {
            parkingSpotList = new ArrayList<>();
            parkingSpot = new ParkingSpot((10*(i+1) + 0), ParkingSpotType.SMALL, 100.0, true);
            parkingSpotDao.addParkingSpot(10*(i+1) +0, parkingSpot);
            parkingSpotList.add(parkingSpot);
            parkingSpot = new ParkingSpot(10*(i+1) +1, ParkingSpotType.MEDIUM, 150.0, true);
            parkingSpotDao.addParkingSpot(10*(i+1) +1, parkingSpot);
            parkingSpotList.add(parkingSpot);
            parkingSpot = new ParkingSpot(10*(i+1) + 2, ParkingSpotType.LARGE, 150.0, true);
            parkingSpotDao.addParkingSpot(10*(i+1) + 2, parkingSpot);
            parkingSpotList.add(parkingSpot);
            parkingLevel = new ParkingLevel(i, parkingSpotList);
            parkingLevelDao.addParkingLevel(i, parkingLevel);
        }
    }

    public static void displayParkingInfo() {
        ParkingService parkingService = new ParkingServiceImpl();
        List<ParkingSpot> parkingSpots = parkingService.availableParkingSpots();
        for(ParkingSpot parkingSpot: parkingSpots) {
            System.out.println(parkingSpot.toString());
        }
    }

    public static void displayTicketInformation(Integer ticketId) {
        VehicleDao vehicleDao = VehicleDao.getInstance();
        TicketDao ticketDao = TicketDao.getInstance();
        Ticket ticket = ticketDao.getTicket(ticketId);
        Vehicle vehicle = vehicleDao.getVehicle(ticket.getVehicleId());
        System.out.println(ticket.toString());
        System.out.println(vehicle.toString());
    }
}