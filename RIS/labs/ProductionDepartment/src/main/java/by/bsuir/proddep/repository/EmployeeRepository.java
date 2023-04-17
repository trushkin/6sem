package by.bsuir.proddep.repository;

import by.bsuir.proddep.entity.Employee;
import by.bsuir.proddep.entity.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    @Override
    Optional<Employee> findById(Integer id);

    Optional<Employee> findByEmail(String email);

    List<Employee> findByRoleNot(Role role);
}
