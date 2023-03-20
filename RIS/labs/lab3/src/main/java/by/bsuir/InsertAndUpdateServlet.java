package by.bsuir;

import by.bsuir.validation.CustomerValidator;
import by.bsuir.validation.ValidationResult;
import jakarta.ejb.EJB;
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
        if (!req.getParameter("creditLimit").equals("")) {
            String name = req.getParameter("name");
            String surname = req.getParameter("surname");
            String city = req.getParameter("city");
            String mainAddress = req.getParameter("mainAddress");
            String additionalAddress = req.getParameter("additionalAddress");
            String creditLimit = req.getParameter("creditLimit");
            Customer customer = new Customer(name, surname, city, Integer.parseInt(creditLimit), mainAddress, additionalAddress);
            ValidationResult validationResult;
            CustomerValidator validator = new CustomerValidator();
            validationResult = validator.validate(customer);
            List<ValidationResult.ValidationError> errorList = validationResult.getErrors();
            if (errorList.isEmpty()) {
                customerService.insert(customer);
            } else {
                for (ValidationResult.ValidationError curErr : errorList) {
                    req.setAttribute("insert" + curErr.getFieldIdentifier(), curErr.getErrorMessage());
                }
            }

        } else {
            req.setAttribute("insertCreditLimitErr", "Credit limit cannot be empty");
        }
        List<Customer> customers = customerService.getAll();
        req.setAttribute("customersToTable", customers);
        req.setAttribute("customersToDropdown", customerService.getAll());
        getServletContext().getRequestDispatcher("/main.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (!req.getParameter("creditLimit").equals("")) {
            String name = req.getParameter("name");
            String surname = req.getParameter("surname");
            String city = req.getParameter("city");
            String mainAddress = req.getParameter("mainAddress");
            String additionalAddress = req.getParameter("additionalAddress");
            Customer customer = new Customer(Integer.parseInt(req.getParameter("id")), name, surname, city, Integer.parseInt(req.getParameter("creditLimit")), mainAddress, additionalAddress);
            CustomerValidator validator = new CustomerValidator();
            ValidationResult validationResult = validator.validate(customer);
            List<ValidationResult.ValidationError> errorList = validationResult.getErrors();
            if (errorList.isEmpty()) {
                customerService.update(customer);
            } else {
                for (ValidationResult.ValidationError curErr : errorList) {
                    req.setAttribute("update" + curErr.getFieldIdentifier(), curErr.getErrorMessage());
                }
            }

        } else {
            req.setAttribute("updateCreditLimitErr", "Credit limit cannot be empty");
        }
        List<Customer> customers = customerService.getAll();
        req.setAttribute("customersToTable", customers);
        req.setAttribute("customersToDropdown", customerService.getAll());
        getServletContext().getRequestDispatcher("/main.jsp").forward(req, resp);
    }
}
