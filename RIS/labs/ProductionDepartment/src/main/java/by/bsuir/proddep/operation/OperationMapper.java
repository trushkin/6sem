package by.bsuir.proddep.operation;

import by.bsuir.proddep.specification.SpecificationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class OperationMapper {
    private final SpecificationRepository specificationRepository;
    public OperationDto toOperationDto(Operation operation){
        return OperationDto.builder()
                .id(operation.getId())
                .name(operation.getName())
                .queue(operation.getQueue())
                .time(operation.getTime())
                .specificationId(operation.getSpecification().getId())
                .build();
    }
    public Operation toOperationEntity(OperationDto operationDto){
        return Operation.builder()
                .id(operationDto.getId())
                .name(operationDto.getName())
                .queue(operationDto.getQueue())
                .time(operationDto.getTime())
                .specification(specificationRepository.findById(operationDto.getSpecificationId()).get())
                .build();
    }
}
