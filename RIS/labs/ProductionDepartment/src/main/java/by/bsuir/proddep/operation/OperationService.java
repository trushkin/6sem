package by.bsuir.proddep.operation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OperationService {
 private final OperationRepository operationRepository;
 private final OperationMapper operationMapper;
    public List<OperationDto> getAllOperation() {
        return operationRepository.findAll().stream().map(operationMapper::toOperationDto).toList();
    }
    public OperationDto addOperation(OperationDto operationDto) {
        Operation operation = operationRepository.save(operationMapper.toOperationEntity(operationDto));
        return operationMapper.toOperationDto(operation);
    }


    public OperationDto updateOperation(OperationDto operationDto) {
        Operation entityOperation = operationMapper.toOperationEntity(operationDto);
        Operation updatedOperation = operationRepository.save(entityOperation);
        return operationMapper.toOperationDto(updatedOperation);
    }
    public OperationDto getOperationById(Integer operationId){
        Optional<Operation> operation = operationRepository.findById(operationId);
        return operationMapper.toOperationDto(operation.get());
    }
}
