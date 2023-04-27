package by.bsuir.proddep.employee;

import by.bsuir.proddep.exception.BusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
        return employeeRepository.findByRoleNotOrderByIdAsc(Role.ADMIN).stream().map(employeeMapper::toEmployeeDto).toList();
    }

    @Override
    public EmployeeDto getEmployee() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        return employeeMapper.toEmployeeDto(employeeRepository
                .findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found")));
    }

    @Override
    public boolean changePassword(ChangePasswordRequest changePasswordRequest) {
        EmployeeDto employee = this.getEmployee();

        String oldPassword = changePasswordRequest.getOldPassword();
        String newPassword = changePasswordRequest.getNewPassword();

        if (passwordEncoder.matches(newPassword, employee.getPassword()) || newPassword.equals(oldPassword)) {
            throw new BusinessException("Новый и старый пароли не должны совпадать!", HttpStatus.CONFLICT);
        }
        if (!passwordEncoder.matches(oldPassword, employee.getPassword())) {
            throw new BusinessException("Старый пароль введен неверно", HttpStatus.BAD_REQUEST);
        }

        employee.setPassword(passwordEncoder.encode(newPassword));
        employeeRepository.save(employeeMapper.toEmployeeEntity(employee));
        return true;
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
