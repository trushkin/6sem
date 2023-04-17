package by.bsuir.proddep.service;

import by.bsuir.proddep.dto.response.EmployeeResponse;
import by.bsuir.proddep.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List <EmployeeResponse> getAllEmployees();
    void addEmployee(Employee employee);
    void saveDeleteEmployee(Integer id);
    void update(Employee employee);
     Employee getUserById();
}
