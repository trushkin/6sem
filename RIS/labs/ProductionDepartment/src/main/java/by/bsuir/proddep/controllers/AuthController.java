package by.bsuir.proddep.controllers;

import by.bsuir.proddep.dto.request.AuthenticationRequest;
import by.bsuir.proddep.dto.response.AuthenticationResponse;
import by.bsuir.proddep.service.AuthenticationService;
import by.bsuir.proddep.service.beans.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthenticationService service;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<AuthenticationResponse> auth(@RequestBody AuthenticationRequest request) {
       // employeeService.addEmployee(new Employee(passwordEncoder.encode("1234"), "admin@gmail.com", "first", "middle", "last", Role.ADMIN, true));
        System.out.println(passwordEncoder.encode("1234"));
        return ResponseEntity.ok(service.authenticate(request));
    }
}
