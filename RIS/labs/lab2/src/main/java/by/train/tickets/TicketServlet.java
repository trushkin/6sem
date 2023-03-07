package by.train.tickets;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

@WebServlet(value = "/tickets")
public class TicketServlet extends HttpServlet {
    private final String FILE_NAME = "tickets.txt";
    @EJB
    TicketService ticketService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<RailwayTicket> railwayTicketList;
        String price = req.getParameter("price");
        if (price != null) {
            try {
                int parsedPrice = Integer.parseInt(price);
                if (parsedPrice <= 0) {
                    req.setAttribute("err", "Price should be bigger than 0");
                    railwayTicketList = ticketService.getAllTickets();
                } else {
                    railwayTicketList = ticketService.getTicketsWithPriceLower(parsedPrice);
                    req.setAttribute("price", parsedPrice);
                }
            } catch (NumberFormatException e) {
                req.setAttribute("err", "Please enter number");
                railwayTicketList = ticketService.getAllTickets();
            }
        } else {
            railwayTicketList = ticketService.getAllTickets();

        }
        req.setAttribute("ticketList", railwayTicketList);
        getServletContext().getRequestDispatcher("/tickets.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String trainNum = req.getParameter("trainNum");
        if (!trainNum.equals("")) {
            List<RailwayTicket> trainTickets = ticketService.getTickets(Integer.parseInt(trainNum));
            if (trainTickets.size() == 0) {
                req.setAttribute("postErr", "No tickets found");
                req.setAttribute("ticketList", ticketService.getAllTickets());
                getServletContext().getRequestDispatcher("/tickets.jsp").forward(req, resp);
            } else {
                resp.setContentType("text/plain");
                resp.setHeader("Content-Disposition", "attachment;filename=" + FILE_NAME);
                OutputStream out = resp.getOutputStream();
                TicketStringSerializer ticketSerializer = new TicketStringSerializer();
                out.write(ticketSerializer.serialize(trainTickets));
                out.flush();
            }
        } else {
            req.setAttribute("postErr", "Please enter number");
            req.setAttribute("ticketList", ticketService.getAllTickets());
            getServletContext().getRequestDispatcher("/tickets.jsp").forward(req, resp);
        }
    }
}
