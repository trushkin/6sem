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
        String id = req.getParameter("id");
        if (id != null) {
            try {
                int parsedId = Integer.parseInt(id);
                if (parsedId < 0) {
                    req.setAttribute("getByIdErr", "Id should be bigger than 0");
                    customers = customerService.getAll();
                } else {
                    customers.add(customerService.getCustomerById(parsedId));
                    req.setAttribute("id", parsedId);
                }
            } catch (NumberFormatException e) {
                req.setAttribute("getByIdErr", "Please enter number");
                customers = customerService.getAll();
            }
        } else {
            customers = customerService.getAll();
        }
        req.setAttribute("customers", customers);
        getServletContext().getRequestDispatcher("/main.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Customer> customers;
        String id = req.getParameter("id");
        if (id != null) {
            try {
                int parsedId = Integer.parseInt(id);
                if (parsedId < 0) {
                    req.setAttribute("deleteErr", "Id should be greater than 0");
                } else {
                    if (!customerService.delete(parsedId)) {
                        req.setAttribute("deleteErr", "No customer with such id");
                    }
                }
            } catch (NumberFormatException e) {
                req.setAttribute("deleteErr", "Please enter number");
            }
        }
        customers = customerService.getAll();
        req.setAttribute("customers", customers);
        getServletContext().getRequestDispatcher("/main.jsp").forward(req, resp);
    }
}
