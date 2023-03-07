package by.train.tickets;

import java.util.List;

class TicketStringSerializer {
    public byte[] serialize(List<RailwayTicket> ticketList) {
        StringBuilder tickets = new StringBuilder();
        for (RailwayTicket currentRailwayTicket : ticketList) {
            String serializedTicket = serializeTicket(currentRailwayTicket);
            tickets.append(serializedTicket).append("\n");
        }
        return tickets.toString().getBytes();
    }
    public String serializeTicket(RailwayTicket ticket) {
        return "RailwayTicket{" +
                "ticketId=" + ticket.getTicketId() +
                ", ticketType=" + ticket.getTicketType() +
                ", trainNum=" + ticket.getTrainNum() +
                ", price=" + ticket.getPrice() +
                ", ticketClass=" + ticket.getTicketClass() +
                '}';
    }
}
