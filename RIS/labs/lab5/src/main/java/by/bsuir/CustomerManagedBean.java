package by.bsuir;

import jakarta.ejb.EJB;
import jakarta.faces.bean.ManagedBean;

import java.util.List;

@ManagedBean(name = "customerManagedBean")
public class CustomerManagedBean {
    @EJB
    CustomerService customerService;

    public List<Customer> getAllCustomers() {
        return customerService.getAll();

    }
}
