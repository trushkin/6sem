package by.bsuir.proddep.dto.mapper;

import by.bsuir.proddep.dto.response.EmployeeResponse;
import by.bsuir.proddep.entity.Employee;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class EmployeeMapper {
    public EmployeeResponse toResponseDto(Employee employee){
        return EmployeeResponse.builder()
                .id(employee.getId())
                .firstName(employee.getFirstName())
                .middleName(employee.getMiddleName())
                .lastName(employee.getLastName())
                .email(employee.getEmail())
                .role(employee.getRole())
                .active(employee.isActive()).build();
    }
}
