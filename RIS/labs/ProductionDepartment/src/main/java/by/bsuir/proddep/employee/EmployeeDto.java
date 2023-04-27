package by.bsuir.proddep.employee;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {
    Integer id;
    String email;
    String password;
    String firstName;
    String middleName;
    String lastName;
    Role role;
    boolean active;

}

