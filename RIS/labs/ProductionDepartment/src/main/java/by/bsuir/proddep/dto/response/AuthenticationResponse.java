package by.bsuir.proddep.dto.response;

import by.bsuir.proddep.entity.Employee;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse {
    private EmployeeResponse employee;
    private String token;
}
