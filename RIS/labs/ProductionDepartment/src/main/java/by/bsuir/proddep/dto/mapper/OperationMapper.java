package by.bsuir.proddep.dto.mapper;

import by.bsuir.proddep.dto.EmployeeDto;
import by.bsuir.proddep.dto.OperationDto;
import by.bsuir.proddep.entity.Employee;
import by.bsuir.proddep.entity.Operation;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class OperationMapper {
    public OperationDto toOperationDto(Operation operation){
        return OperationDto.builder()
                .id(operation.getId())
                .name(operation.getName())
                .build();
    }
    public Operation toOperationEntity(OperationDto operationDto){
        return Operation.builder()
                .id(operationDto.getId())
                .name(operationDto.getName())
                .build();
    }
}
