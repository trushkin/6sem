package by.bsuir;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(value = "/getByIdAndDelete")
public class GetByIdAndDeleteServlet extends HttpServlet {
    @EJB
    CustomerService customerService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Customer> customers = new ArrayList<>();
        req.setAttribute("customersToDropdown", customerService.getAll());
        if (req.getParameter("customerToPrint") != null) {
            customers.add(customerService.getCustomerById(Integer.parseInt(req.getParameter("customerToPrint"))));
        } else {
            customers = customerService.getAll();
        }
        req.setAttribute("customersToTable", customers);
        getServletContext().getRequestDispatcher("/main.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (req.getParameter("customerToDelete") != null) {
            customerService.delete(Integer.parseInt(req.getParameter("customerToDelete")));
        } else {
            req.setAttribute("deleteErr", "Please, choose customer to delete");
        }
        resp.sendRedirect(req.getRequestURI());
    }
}
