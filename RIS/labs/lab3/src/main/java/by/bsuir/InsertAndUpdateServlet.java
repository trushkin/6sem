package by.bsuir;

import jakarta.ejb.EJB;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(value = "/insertAndUpdate")
public class InsertAndUpdateServlet extends HttpServlet {
    @EJB
    CustomerService customerService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String city = req.getParameter("city");
        String mainAddress = req.getParameter("mainAddress");
        String additionalAddress = req.getParameter("additionalAddress");
        if (name.equals("") || surname.equals("") || city.equals("") || req.getParameter("creditLimit").equals("") || mainAddress.equals("") || additionalAddress.equals("")) {
            req.setAttribute("insertErr", "Issue with parameters, try again!");
        } else {
            int creditLimit = Integer.parseInt(req.getParameter("creditLimit"));
            if (creditLimit < 0) {
                req.setAttribute("insertErr", "Credit limit should be greater than 0");
            } else {
                customerService.insert(new Customer(name, surname, city, creditLimit, mainAddress, additionalAddress));
            }
        }
        List<Customer> customers = customerService.getAll();
        req.setAttribute("customers", customers);
        getServletContext().getRequestDispatcher("/main.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String city = req.getParameter("city");
        String mainAddress = req.getParameter("mainAddress");
        String additionalAddress = req.getParameter("additionalAddress");
        if (name.equals("") || surname.equals("") || city.equals("") || req.getParameter("creditLimit").equals("") || mainAddress.equals("") || additionalAddress.equals("") || req.getParameter("id").equals("")) {
            req.setAttribute("updateErr", "Issue with parameters, try again!");
        } else {
            int id = Integer.parseInt(req.getParameter("id"));
            int creditLimit = Integer.parseInt(req.getParameter("creditLimit"));
            if (creditLimit < 0 || id < 0) {
                req.setAttribute("updateErr", "Credit limit and id should be greater than 0");
            } else {
                customerService.update(new Customer(id, name, surname, city, creditLimit, mainAddress, additionalAddress));
            }
        }
        List<Customer> customers = customerService.getAll();
        req.setAttribute("customers", customers);
        getServletContext().getRequestDispatcher("/main.jsp").forward(req, resp);
    }
}
