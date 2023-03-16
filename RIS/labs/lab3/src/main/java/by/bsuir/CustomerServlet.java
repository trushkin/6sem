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

@WebServlet(value = "/mainPage")
public class CustomerServlet extends HttpServlet {
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
                    req.setAttribute("err", "Id should be bigger than 0");
                    customers = customerService.getAll();
                } else {
                    customers.add(customerService.getCustomerById(parsedId));
                    req.setAttribute("id", parsedId);
                }
            }catch (NumberFormatException e){
                req.setAttribute("err", "Please enter number");
               customers = customerService.getAll();
            }
        } else {
            customers = customerService.getAll();
        }
        req.setAttribute("customers", customers);
        getServletContext().getRequestDispatcher("/main.jsp").forward(req, resp);
    }
}
