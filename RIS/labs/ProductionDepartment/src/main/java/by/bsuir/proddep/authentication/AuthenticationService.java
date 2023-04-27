package by.bsuir.proddep.authentication;

import by.bsuir.proddep.authentication.AuthenticationRequest;
import by.bsuir.proddep.authentication.AuthenticationResponse;
import by.bsuir.proddep.employee.EmployeeDto;
import by.bsuir.proddep.employee.Employee;
import by.bsuir.proddep.employee.EmployeeRepository;
import by.bsuir.proddep.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final EmployeeRepository repository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
//        authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(
//                        request.getEmail(),
//                        request.getPassword()
//                )
//        );
//        Employee user = repository.findByEmail(request.getEmail())
//                .orElseThrow();
//        String jwtToken = jwtService.generateToken(user);
//        return AuthenticationResponse.builder()
//                .token(jwtToken)
//                .build();
        Authentication authenticate = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        Employee user = repository.findByEmail(request.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException(String.format("User with email %s not found", request.getEmail())));
        String jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .employee(EmployeeDto.builder()
                        .firstName(user.getFirstName())
                        .middleName(user.getMiddleName())
                        .lastName(user.getLastName())
                        .email(user.getUsername())
                        .role(user.getRole())
                        .active(user.isActive())
                        .build())
                .build();
    }
}