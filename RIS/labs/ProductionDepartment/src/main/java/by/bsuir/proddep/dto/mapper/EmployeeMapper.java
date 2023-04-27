package by.bsuir.proddep.dto.mapper;

import by.bsuir.proddep.dto.EmployeeDto;
import by.bsuir.proddep.entity.Employee;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class EmployeeMapper {
    public EmployeeDto toEmployeeDto(Employee employee){
        return EmployeeDto.builder()
                .id(employee.getId())
                .firstName(employee.getFirstName())
                .middleName(employee.getMiddleName())
                .lastName(employee.getLastName())
                .email(employee.getEmail())
                .role(employee.getRole())
                .active(employee.isActive()).build();
    }
    public Employee toEmployeeEntity(EmployeeDto employeeDto){
        return Employee.builder()
                .id(employeeDto.getId())
                .firstName(employeeDto.getFirstName())
                .password(employeeDto.getPassword())
                .middleName(employeeDto.getMiddleName())
                .lastName(employeeDto.getLastName())
                .email(employeeDto.getEmail())
                .role(employeeDto.getRole())
                .isActive(employeeDto.isActive()).build();
    }
}
