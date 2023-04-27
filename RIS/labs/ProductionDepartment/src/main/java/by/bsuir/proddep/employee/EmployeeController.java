package by.bsuir.proddep.employee;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployees() {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }
    @PostMapping
    public ResponseEntity<EmployeeDto> addEmployee(@RequestBody EmployeeDto employeeDto){
        return ResponseEntity.ok(employeeService.addEmployee(employeeDto));
    }
    @PutMapping
    public ResponseEntity<EmployeeDto> updateEmployee(@RequestBody EmployeeDto employeeDto){
        return ResponseEntity.ok(employeeService.updateEmployee(employeeDto));
    }
    @GetMapping("/user")
    public ResponseEntity<EmployeeDto> getUserInfo(){
        return ResponseEntity.ok(employeeService.getEmployee());
    }
    @PutMapping("/changePassword")
    public ResponseEntity<Boolean> changePassword(@RequestBody ChangePasswordRequest changePasswordRequest){
        return ResponseEntity.ok().body(employeeService.changePassword(changePasswordRequest));
    }

}
