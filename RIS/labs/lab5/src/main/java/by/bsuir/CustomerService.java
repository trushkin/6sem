package by.bsuir;

import jakarta.ejb.Local;

import java.util.List;

@Local
public interface CustomerService {
    List<Customer> getAll();
    Customer getCustomerById(int id);
    void insert(Customer customer);
    boolean delete(int id);
    void update(Customer customer);
}
