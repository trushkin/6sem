package by.bsuir.proddep.service;

import by.bsuir.proddep.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    List <EmployeeDto> getAllEmployees();
    EmployeeDto addEmployee(EmployeeDto employeeDto);
    void saveDeleteEmployee(Integer id);
    EmployeeDto updateEmployee(EmployeeDto employeeDto);
     EmployeeDto getEmployee();
}
