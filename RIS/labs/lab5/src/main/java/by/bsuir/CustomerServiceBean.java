package by.bsuir;

import jakarta.ejb.Stateless;
import jakarta.ejb.TransactionAttribute;
import jakarta.ejb.TransactionAttributeType;
import jakarta.ejb.TransactionManagement;
import jakarta.ejb.TransactionManagementType;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;


@Stateless
//@TransactionManagement(TransactionManagementType.CONTAINER)
public class CustomerServiceBean implements CustomerService {

    @PersistenceContext(unitName = "CustomerManagement")
    private EntityManager entityManager;

  //  @TransactionAttribute(TransactionAttributeType.REQUIRED)
    @Override
    public List<Customer> getAll() {
        return entityManager.createQuery("select c from Customer c", Customer.class).getResultList();
    }

    @Override
    public Customer getCustomerById(int id) {
        return entityManager.find(Customer.class, id);
    }

    @Override
    public void insert(Customer customer) {
        entityManager.persist(customer);
    }

    @Override
    public boolean delete(int id) {
        Customer customerToDelete = entityManager.find(Customer.class, id);
        if (customerToDelete != null) {
            entityManager.remove(customerToDelete);
            return true;
        }
        return false;
    }

    @Override
    public void update(Customer updatedDetails) {
        Customer customerToUpdate = entityManager.find(Customer.class, updatedDetails.getId());
        customerToUpdate.setName(updatedDetails.getName());
        customerToUpdate.setSurname(updatedDetails.getSurname());
        customerToUpdate.setCity(updatedDetails.getCity());
        customerToUpdate.setCreditLimit(updatedDetails.getCreditLimit());
        customerToUpdate.setMainAddress(updatedDetails.getMainAddress());
        customerToUpdate.setAdditionalAddress(updatedDetails.getAdditionalAddress());
        entityManager.merge(customerToUpdate);

    }
}
