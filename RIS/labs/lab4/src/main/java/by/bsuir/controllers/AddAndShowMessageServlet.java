package by.bsuir.controllers;

import by.bsuir.MessageService;
import jakarta.ejb.EJB;
import jakarta.jms.JMSException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet(value = "/addAndShowMessage")
public class AddAndShowMessageServlet extends HttpServlet {
    @EJB
    MessageService messageService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("messages", messageService.getAllMessages());
        getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            messageService.addString(req.getParameter("messageToAdd"));
        } catch (JMSException ex) {
            throw new RuntimeException(ex);
        }
        resp.sendRedirect("addAndShowMessage");
    }
}