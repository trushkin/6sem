package by.bsuir.proddep.dto.response;

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
public class EmployeeResponse {
    Integer id;
    String email;
    String firstName;
    String middleName;
    String lastName;
    Role role;
    boolean active;
}

