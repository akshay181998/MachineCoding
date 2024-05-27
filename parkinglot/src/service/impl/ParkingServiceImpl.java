package service.impl;

import dao.CustomerDao;
import dao.ParkingLevelDao;
import dao.ParkingSpotDao;
import dao.TicketDao;
import dto.Customer;
import dto.ParkingLevel;
import dto.ParkingSpot;
import dto.Ticket;
import service.ParkingService;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class ParkingServiceImpl implements ParkingService {
    @Override
    public List<ParkingSpot> availableParkingSpots() {
        ParkingLevelDao parkingLevelDao = ParkingLevelDao.getInstance();
        List<ParkingLevel> parkingLevels = parkingLevelDao.getAllParkingLevel();
        List<ParkingSpot> allParkingSpots = new ArrayList<>();
        for(ParkingLevel parkingLevel: parkingLevels) {
            for(ParkingSpot parkingSpot: parkingLevel.getParkingSpots()) {
                if(parkingSpot.getAvailable()) {
                    allParkingSpots.add(parkingSpot);
                }
            }
        }
        return allParkingSpots;
    }

    @Override
    public void allotParkingSpot(Customer customer, ParkingSpot parkingSpot) {
        ParkingSpotDao parkingSpotDao = ParkingSpotDao.getInstance();
        CustomerDao customerDao = CustomerDao.getInstance();
        TicketDao ticketDao = TicketDao.getInstance();
        customerDao.addCustomer(customer.getCustomerId(), customer);
        parkingSpotDao.updateParkingSpot(parkingSpot.getParkingSpotId());
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Ticket ticket = new Ticket(timestamp, null, customer.getVehicleId(), parkingSpot.getParkingCharges(), parkingSpot.getParkingSpotId());
        customer.setTicketId(ticket.getTicketId());
        customerDao.updateCustomer(customer.getCustomerId(), customer);
        ticketDao.addTicket(ticket.getTicketId(), ticket);
    }

    @Override
    public void releaseParkingSpot(Integer ticketId) {
        TicketDao ticketDao = TicketDao.getInstance();
        Ticket ticket = ticketDao.getTicket(ticketId);
        ticket.setCheckOutTime(new Timestamp(System.currentTimeMillis()));
        ticketDao.updateTicket(ticketId, ticket);
        ParkingSpotDao parkingSpotDao = ParkingSpotDao.getInstance();
        ParkingSpot parkingSpot = parkingSpotDao.getParkingSpot(ticket.getParkingSpotId());
        parkingSpotDao.updateParkingSpot(ticket.getParkingSpotId());
    }
}
