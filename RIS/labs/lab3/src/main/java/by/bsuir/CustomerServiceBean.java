package by.bsuir;

import jakarta.ejb.Stateful;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.List;

@Stateful
public class CustomerServiceBean implements CustomerService {

//    @PersistenceContext(type = PersistenceContextType.EXTENDED)
//    private EntityManager entityManager;
//
//    @Override
//    public List<Customer> getAll() {
//        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
//        CriteriaQuery<Customer> getAll = criteriaBuilder.createQuery(Customer.class);
//        Root<Customer> root = getAll.from(Customer.class);
//        getAll.select(root);
//        return entityManager.createQuery(getAll).getResultList();
//
//    }

    private final EntityManagerFactory entityManagerFactory;

    public CustomerServiceBean() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory("CustomerManagement");
    }

    @Override
    public List<Customer> getAll() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        // JQL (JPA query language)
        return entityManager.createQuery("select c from Customer c", Customer.class).getResultList();
    }

    @Override
    public Customer getCustomerById(int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createQuery("select c from Customer c where c.id =:id", Customer.class);
        query.setParameter("id", id);
        return (Customer) query.getSingleResult();
    }

//private final EntityManagerFactory entityManagerFactory;
//
//    public CustomerServiceBean() {
//        this.entityManagerFactory = Persistence.createEntityManagerFactory("CustomerManagement");
//    }
//    @Override
//    public List<Customer> getAll() {
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
//        CriteriaQuery<Customer> getAll = criteriaBuilder.createQuery(Customer.class);
//        Root<Customer> root = getAll.from(Customer.class);
//        getAll.select(root);
//        try {
//            return entityManager.createQuery(getAll).getResultList();
//        } finally {
//            entityManager.close();
//        }
//    }

}
