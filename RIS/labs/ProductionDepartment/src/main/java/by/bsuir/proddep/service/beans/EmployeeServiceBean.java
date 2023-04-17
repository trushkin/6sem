package by.bsuir.proddep.service.beans;

import by.bsuir.proddep.dto.mapper.EmployeeMapper;
import by.bsuir.proddep.dto.response.EmployeeResponse;
import by.bsuir.proddep.entity.enums.Role;
import by.bsuir.proddep.repository.EmployeeRepository;
import by.bsuir.proddep.entity.Employee;
import by.bsuir.proddep.repository.ItemRepository;
import by.bsuir.proddep.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeServiceBean implements EmployeeService {
    private final EmployeeMapper employeeMapper;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private ItemRepository itemRepository;

    @Override
    public List<EmployeeResponse> getAllEmployees() {
         return employeeRepository.findByRoleNot(Role.ADMIN).stream().map(employeeMapper::toResponseDto).toList();
        //return employeeRepository.findAll().stream().map(employeeMapper::toResponseDto).toList();
    }

    @Override
    public Employee getUserById() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        System.out.println(email);
        return employeeRepository
                .findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    @Override
    public void addEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void saveDeleteEmployee(Integer id) {
        Optional<Employee> employeeToSaveDelete = employeeRepository.findById(id);
        employeeToSaveDelete.ifPresent(employee -> {
            employee.setActive(false);
            employeeRepository.save(employee);
        });
    }

    @Override
    public void update(Employee updatedEmployeeDetails) {
        Optional<Employee> employeeToUpdate = employeeRepository.findById(updatedEmployeeDetails.getId());
        employeeToUpdate.ifPresent(employee -> {
            employeeRepository.save(employee);
        });
    }

}
