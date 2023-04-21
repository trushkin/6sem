package by.bsuir.proddep.dto;

import by.bsuir.proddep.entity.enums.Role;
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
    String firstName;
    String middleName;
    String lastName;
    Role role;
    boolean active;

}

