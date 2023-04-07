package by.bsuir.proddep;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class EmployeeServiceBean implements EmployeeService {
    @Autowired
    private  EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {
        //  Employee employee = new Employee("1", "1", "1", "1", Role.TECHNOLOGIST);
        // employees.add(employee);
        return new ArrayList<>(employeeRepository.findAll());
    }

}
