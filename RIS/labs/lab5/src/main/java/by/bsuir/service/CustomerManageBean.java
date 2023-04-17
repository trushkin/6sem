package by.bsuir.service;

import by.bsuir.entity.Customer;
import by.bsuir.repository.CustomerService;
import by.bsuir.repository.CustomerServiceBean;
import jakarta.ejb.EJB;
import jakarta.faces.bean.ManagedBean;

@ManagedBean()
public class CustomerManageBean {
    @EJB
    private CustomerService repository;
    private String id;
    private String name;
    private String surname;
    private String email;
    private String zipcode;
    private Customer customer;
    private boolean isAdded;

    public void addCustomer() {
        repository.addCustomer(name, surname, email, Integer.parseInt(zipcode));
        isAdded = true;
    }

    public void deleteCustomer() {
        this.customer = repository.getCustomerById(Long.parseLong(id));
        repository.deleteCustomer(Long.parseLong(id));
    }

    public void getCustomerById() {
        Customer customer = repository.getCustomerById(Long.parseLong(id));
        if (customer != null) {
            id = String.valueOf(customer.getId());
            name = customer.getName();
            surname = customer.getSurname();
            email = customer.getEmail();
            zipcode = String.valueOf(customer.getZipCode());
        }
        this.customer = customer;
    }

    public void editCustomer() {
        Customer customer1 = repository.getCustomerById(Long.parseLong(id));
        if (customer1 != null) {
            customer = new Customer(Long.parseLong(id), name, surname, Integer.parseInt(zipcode), email);
            repository.editCustomer(customer);
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public boolean isAdded() {
        return isAdded;
    }

    public void setAdded(boolean added) {
        isAdded = added;
    }
}
