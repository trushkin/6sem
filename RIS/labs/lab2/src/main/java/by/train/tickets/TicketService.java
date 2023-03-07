package by.train.tickets;

import jakarta.ejb.Local;

import java.util.List;

@Local
public interface TicketService {
    List<RailwayTicket> getTickets(int trainNum);
    List<RailwayTicket> getAllTickets();
    List<RailwayTicket> getTicketsWithPriceLower(int price);
    List<RailwayTicket> deleteFirstElem();
}
