package by.bsuir.repository;

import by.bsuir.entity.Customer;
import jakarta.ejb.Stateless;
import jakarta.ejb.TransactionAttribute;
import jakarta.ejb.TransactionAttributeType;
import jakarta.ejb.TransactionManagement;
import jakarta.ejb.TransactionManagementType;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class CustomerServiceBean implements CustomerService {
    @PersistenceContext(unitName = "CustomerManagement")
    private EntityManager entityManager;
    @TransactionAttribute(TransactionAttributeType.NEVER)
    @Override
    public List<Customer> getAllCustomers() {
        return entityManager.createQuery("select c from Customer c", Customer.class).getResultList();
    }
    @TransactionAttribute(TransactionAttributeType.NEVER)
    @Override
    public Customer getCustomerById(Long id) {
        return entityManager.find(Customer.class, id);
    }

    @Override
    public void editCustomer(Customer newCustomer) {
        Customer customer = entityManager.find(Customer.class, newCustomer.getId());
        customer.setName(newCustomer.getName());
        customer.setSurname(newCustomer.getSurname());
        customer.setEmail(newCustomer.getEmail());
        customer.setZipCode(newCustomer.getZipCode());
        entityManager.merge(customer);
    }

    @Override
    public void addCustomer(String name, String surname, String email, int zipcode) {
        entityManager.persist(new Customer(null, name, surname, zipcode, email));
    }

    @Override
    public void deleteCustomer(Long id) {
        Customer customerToDelete = entityManager.find(Customer.class, id);
        if (customerToDelete != null) {
            entityManager.remove(customerToDelete);
        }
    }
}
