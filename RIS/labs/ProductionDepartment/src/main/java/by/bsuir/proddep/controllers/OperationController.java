package by.bsuir.proddep.controllers;

import by.bsuir.proddep.dto.EmployeeDto;
import by.bsuir.proddep.dto.OperationDto;
import by.bsuir.proddep.dto.request.ChangePasswordRequest;
import by.bsuir.proddep.service.OperationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/operations")
@RequiredArgsConstructor
public class OperationController {
    @Autowired
    OperationService operationService;

    @GetMapping
    public ResponseEntity<List<OperationDto>> getAllOperations() {
        return ResponseEntity.ok(operationService.getAllOperation());
    }
    @PostMapping
    public ResponseEntity<OperationDto> addOperation(@RequestBody OperationDto operationDto){

        return ResponseEntity.ok(operationService.addOperation(operationDto));
    }
    @PutMapping
    public ResponseEntity<OperationDto> updateOperation(@RequestBody OperationDto operationDto){
        return ResponseEntity.ok(operationService.updateOperation(operationDto));
    }

}
