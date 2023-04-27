package by.bsuir.proddep.service.beans;

import by.bsuir.proddep.dto.mapper.EmployeeMapper;
import by.bsuir.proddep.dto.EmployeeDto;
import by.bsuir.proddep.dto.request.ChangePasswordRequest;
import by.bsuir.proddep.entity.enums.Role;
import by.bsuir.proddep.repository.EmployeeRepository;
import by.bsuir.proddep.entity.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;

@Service
@RequiredArgsConstructor
public class EmployeeServiceBean implements EmployeeService {
    private final EmployeeMapper employeeMapper;
    @Autowired
    private EmployeeRepository employeeRepository;
    private final PasswordEncoder passwordEncoder;

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
    public boolean changePassword(ChangePasswordRequest changePasswordRequest) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        String oldPassword = passwordEncoder.encode(changePasswordRequest.getOldPassword());
        String newPassword = passwordEncoder.encode(changePasswordRequest.getNewPassword());
        AtomicBoolean flag = new AtomicBoolean(false);
        Optional<Employee> employeeToChangePassword = employeeRepository.findByEmail(email);
        employeeToChangePassword.ifPresent(employee -> {
            if (employee.getPassword().equals(oldPassword)) {
                employee.setPassword(newPassword);
                flag.set(true);
            }
        });
        return flag.get();
    }

    @Override
    public EmployeeDto addEmployee(EmployeeDto employeeDto) {
        employeeDto.setPassword(passwordEncoder.encode("1111"));
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
        Employee entityEmployee = employeeMapper.toEmployeeEntity(employeeDto);
        Employee updatedEmployee = employeeRepository.save(entityEmployee);
        EmployeeDto res = employeeMapper.toEmployeeDto(updatedEmployee);
        return res;
    }

}
