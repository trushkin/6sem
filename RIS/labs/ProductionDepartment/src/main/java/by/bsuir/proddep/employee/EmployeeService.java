package by.bsuir.proddep.employee;

import by.bsuir.proddep.employee.EmployeeDto;
import by.bsuir.proddep.employee.ChangePasswordRequest;

import java.util.List;

public interface EmployeeService {
    List <EmployeeDto> getAllEmployees();
    EmployeeDto addEmployee(EmployeeDto employeeDto);
    void saveDeleteEmployee(Integer id);
    EmployeeDto updateEmployee(EmployeeDto employeeDto);
     EmployeeDto getEmployee();
     boolean changePassword(ChangePasswordRequest changePasswordRequest);

}
