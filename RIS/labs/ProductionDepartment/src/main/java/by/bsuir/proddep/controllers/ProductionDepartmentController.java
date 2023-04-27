package by.bsuir.proddep.controllers;

import by.bsuir.proddep.repository.ItemRepository;
import by.bsuir.proddep.service.beans.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"", "/", "index", "index.html"})
public class ProductionDepartmentController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private ItemRepository itemRepository;

//    public ProductionDepartmentController(EmployeeService employeeService) {
//        this.employeeService = employeeService;
//    }

//    @GetMapping("/")
//    public List<Employee> getAll() {
//        return employeeService.getAllEmployees();
//    }
//    @GetMapping("/")
//    public List<Item> getAll() {
//       // itemRepository.save(new Item("test", ItemType.PRODUCT));
//        return itemRepository.findAll();
//    }
//    @GetMapping("/getAllEmployees")
//    public List<Employee> getAll() {
//       // itemRepository.save(new Item("test", ItemType.PRODUCT));
//        return employeeService.getAllEmployees();
//    }
    @GetMapping("/addEmployee")
    public void addEmployee() {
     //  employeeService.addEmployee(new Employee("email", "firstname","middlename", "lastname", Role.DISPATCHER, true));
    }
    @GetMapping("/deleteEmployee")
    public void deleteEmployee() {
        employeeService.saveDeleteEmployee(1);
    }
    @GetMapping("/updateEmployee")
    public void updateEmployee() {
        //employeeService.update(new Employee(1, "email2", "firstname","middlename", "lastname", Role.DISPATCHER, true));
    }
}
