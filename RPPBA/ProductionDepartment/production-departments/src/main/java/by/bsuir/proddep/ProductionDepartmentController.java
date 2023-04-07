package by.bsuir.proddep;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class ProductionDepartmentController {

    private final EmployeeService employeeService;

    public ProductionDepartmentController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/")
    public List<Employee> getAll() {
        return employeeService.getAllEmployees();
    }
}
