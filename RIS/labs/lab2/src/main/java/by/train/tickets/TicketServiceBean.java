package by.train.tickets;

import jakarta.ejb.Stateful;
import jakarta.ejb.Stateless;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

@Stateless
public class TicketServiceBean implements TicketService {
    private List<RailwayTicket> ticketList;

    public TicketServiceBean() {
        ticketList = new ArrayList<>();
        ticketList.add(new RailwayTicket(1, RailwayTicket.TicketType.ADVANCE, 11, 500, RailwayTicket.TicketClass.STANDARD));
        ticketList.add(new RailwayTicket(2, RailwayTicket.TicketType.ANYTIME, 15, 3000, RailwayTicket.TicketClass.FIRST));
        ticketList.add(new RailwayTicket(3, RailwayTicket.TicketType.OFF_PEAK, 15, 200, RailwayTicket.TicketClass.STANDARD));
        ticketList.add(new RailwayTicket(4, RailwayTicket.TicketType.ADVANCE, 11, 1300, RailwayTicket.TicketClass.BUSINESS));
    }

    @Override
    public List<RailwayTicket> getTickets(int trainNum) {
        List<RailwayTicket> result = new ArrayList<>();
        Predicate<RailwayTicket> railwayTicketPredicate = currentRailwayTicket -> currentRailwayTicket.getTrainNum() == trainNum;
        for (RailwayTicket currentRailwayTicket : ticketList) {
            if (railwayTicketPredicate.test(currentRailwayTicket)){
               result.add(currentRailwayTicket);
            }
        }
        return result;
    }

    @Override
    public List<RailwayTicket> getAllTickets() {
        return Collections.unmodifiableList(ticketList);
    }

    @Override
    public List<RailwayTicket> getTicketsWithPriceLower(int price) {
        Predicate<RailwayTicket> railwayTicketPredicate = currentRailwayTicket -> currentRailwayTicket.getPrice() <= price;
        List<RailwayTicket> filteredTicketList = new ArrayList<>();
        for (RailwayTicket currentRailwayTicket : ticketList) {
            if (railwayTicketPredicate.test(currentRailwayTicket)) {
                filteredTicketList.add(currentRailwayTicket);
            }
        }

        return filteredTicketList;
    }

    @Override
    public List<RailwayTicket> deleteFirstElem() {
        ticketList.remove(0);
        return Collections.unmodifiableList(ticketList);
    }
}
