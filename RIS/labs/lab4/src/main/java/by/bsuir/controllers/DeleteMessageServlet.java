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

@WebServlet(value = "/deleteMessage")
public class DeleteMessageServlet extends HttpServlet {
    @EJB
    MessageService messageService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
           messageService.removeString(req.getParameter("messageToDelete"));
        } catch (JMSException ex) {
            throw new RuntimeException(ex);
        }
        resp.sendRedirect("addAndShowMessage");
    }


}
