package dao;

import dto.Ticket;

import java.util.HashMap;

public class TicketDao {
    private final HashMap<Integer, Ticket> tickets;
    public static TicketDao instance;

    private TicketDao() {
        this.tickets = new HashMap<>();
    }

    public static synchronized TicketDao getInstance() {
        if(instance == null) {
            instance = new TicketDao();
        }
        return instance;
    }

    public Ticket getTicket(Integer ticketId) {
        return this.tickets.get(ticketId);
    }

    public void addTicket(Integer ticketId, Ticket ticket) {
        this.tickets.put(ticketId, ticket);
    }

    public  void updateTicket(Integer ticketId, Ticket ticket) {
        this.tickets.put(ticketId, ticket);
    }

    public void removeTicket(Integer ticketId) {
        this.tickets.remove(ticketId);
    }
}
