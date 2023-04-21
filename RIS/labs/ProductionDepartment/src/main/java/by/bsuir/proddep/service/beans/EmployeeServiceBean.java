package by.bsuir.proddep.service.beans;

import by.bsuir.proddep.dto.mapper.EmployeeMapper;
import by.bsuir.proddep.dto.EmployeeDto;
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
    public List<EmployeeDto> getAllEmployees() {
        return employeeRepository.findByRoleNot(Role.ADMIN).stream().map(employeeMapper::toEmployeeDto).toList();
    }

    @Override
    public EmployeeDto getEmployee() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        System.out.println(email);
        return employeeMapper.toEmployeeDto(employeeRepository
                .findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found")));
    }

    @Override
    public EmployeeDto addEmployee(EmployeeDto employeeDto) {
        Employee employee = employeeRepository.save(employeeMapper.toEmployeeEntity(employeeDto));
        return employeeMapper.toEmployeeDto(employee);
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
    public EmployeeDto updateEmployee(EmployeeDto employeeDto) {
        Employee updatedEmployee = employeeRepository.save(employeeMapper.toEmployeeEntity(employeeDto));
        return employeeMapper.toEmployeeDto(updatedEmployee);
    }

}
