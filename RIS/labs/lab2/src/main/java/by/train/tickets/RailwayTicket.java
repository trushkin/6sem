package by.train.tickets;

import java.io.Serializable;
public class RailwayTicket implements Serializable {
    private int ticketId;
    private TicketType ticketType;
    private int trainNum;
    private int price;
    private TicketClass ticketClass;
    public RailwayTicket(int ticketId, TicketType ticketType, int trainNum, int price, TicketClass ticketClass) {
        this.ticketId = ticketId;
        this.ticketType = ticketType;
        this.trainNum = trainNum;
        this.price = price;
        this.ticketClass = ticketClass;
    }

    @Override
    public String toString() {
        return "RailwayTicket{" +
                "ticketId=" + ticketId +
                ", ticketType=" + ticketType +
                ", trainNum=" + trainNum +
                ", price=" + price +
                ", ticketClass=" + ticketClass +
                '}';
    }

    public RailwayTicket() {
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public enum TicketClass{
        FIRST, BUSINESS, STANDARD
    }
    public enum TicketType{
        ANYTIME, OFF_PEAK, ADVANCE
    }

    public TicketType getTicketType() {
        return ticketType;
    }

    public void setTicketType(TicketType ticketType) {
        this.ticketType = ticketType;
    }

    public int getTrainNum() {
        return trainNum;
    }

    public void setTrainNum(int trainNum) {
        this.trainNum = trainNum;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public TicketClass getTicketClass() {
        return ticketClass;
    }

    public void setTicketClass(TicketClass ticketClass) {
        this.ticketClass = ticketClass;
    }



}
