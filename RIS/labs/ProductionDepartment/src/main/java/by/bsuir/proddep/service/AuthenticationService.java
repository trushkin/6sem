package by.bsuir.proddep.service;

import by.bsuir.proddep.dto.request.AuthenticationRequest;
import by.bsuir.proddep.dto.response.AuthenticationResponse;
import by.bsuir.proddep.dto.response.EmployeeResponse;
import by.bsuir.proddep.entity.Employee;
import by.bsuir.proddep.repository.EmployeeRepository;
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
        System.out.println(authenticate.getPrincipal());
        System.out.println("////////////////");
        Employee user = repository.findByEmail(request.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException(String.format("User with email %s not found", request.getEmail())));
        String jwtToken = jwtService.generateToken(user);
        System.out.println(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .employee(EmployeeResponse.builder()
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