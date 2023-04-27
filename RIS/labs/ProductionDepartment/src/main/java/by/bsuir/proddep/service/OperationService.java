package by.bsuir.proddep.service;

import by.bsuir.proddep.dto.OperationDto;
import by.bsuir.proddep.dto.mapper.OperationMapper;
import by.bsuir.proddep.entity.Operation;
import by.bsuir.proddep.repository.OperationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
