package by.bsuir.repository;

import by.bsuir.entity.Customer;
import jakarta.ejb.Local;

import java.util.List;

@Local
public interface CustomerService {
    List<Customer> getAllCustomers();

    Customer getCustomerById(Long id);

    void editCustomer(Customer newCustomer);

    void addCustomer(String name, String surname, String email, int zipcode);

    void deleteCustomer(Long id);
}
