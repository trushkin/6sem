package by.bsuir.proddep.authentication;

import by.bsuir.proddep.employee.EmployeeDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse {
    private EmployeeDto employee;
    private String token;
}
