package service;

import dto.Ticket;

public interface TicketService {
    Ticket genereateTicket(Integer vehicleId, Integer customerId, Integer parkingSpotId);
    Ticket finalTicketAmount(Integer ticketId);
}
