package by.bsuir.proddep.employee;

import by.bsuir.proddep.employee.Employee;
import by.bsuir.proddep.employee.Role;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    @Override
    Optional<Employee> findById(Integer id);

    Optional<Employee> findByEmail(String email);

    List<Employee> findByRoleNotOrderByIdAsc(Role role);

}
