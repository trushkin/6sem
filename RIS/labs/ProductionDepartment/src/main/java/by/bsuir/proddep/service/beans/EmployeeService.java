package by.bsuir.proddep.service.beans;

import by.bsuir.proddep.dto.EmployeeDto;
import by.bsuir.proddep.dto.request.ChangePasswordRequest;

import java.util.List;

public interface EmployeeService {
    List <EmployeeDto> getAllEmployees();
    EmployeeDto addEmployee(EmployeeDto employeeDto);
    void saveDeleteEmployee(Integer id);
    EmployeeDto updateEmployee(EmployeeDto employeeDto);
     EmployeeDto getEmployee();
     boolean changePassword(ChangePasswordRequest changePasswordRequest);

}
