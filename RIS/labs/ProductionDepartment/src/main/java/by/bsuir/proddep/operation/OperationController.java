package by.bsuir.proddep.operation;

import by.bsuir.proddep.operation.OperationDto;
import by.bsuir.proddep.operation.OperationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/operations")
@RequiredArgsConstructor
public class OperationController {
    @Autowired
    OperationService operationService;

    @GetMapping("/asd")
    public ResponseEntity<List<OperationDto>> getAllOperations() {
        return ResponseEntity.ok(operationService.getAllOperation());
    }

    @GetMapping
    public ResponseEntity<OperationDto> getOperation(@RequestParam Integer operationId) {
        return ResponseEntity.ok(operationService.getOperationById(operationId));
    }

    @PostMapping
    public ResponseEntity<OperationDto> addOperation(@RequestBody OperationDto operationDto) {
        return ResponseEntity.ok(operationService.addOperation(operationDto));
    }

    @PutMapping
    public ResponseEntity<OperationDto> updateOperation(@RequestBody OperationDto operationDto) {
        return ResponseEntity.ok(operationService.updateOperation(operationDto));
    }

}
