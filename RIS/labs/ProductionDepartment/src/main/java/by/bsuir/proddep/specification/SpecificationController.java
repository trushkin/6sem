package by.bsuir.proddep.specification;

import by.bsuir.proddep.productionOrder.ProductionOrderDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/specifications")
@RequiredArgsConstructor
public class SpecificationController {
    @Autowired
    SpecificationService specificationService;

    @GetMapping("/zxc")
    public ResponseEntity<List<SpecificationDto>> getAllSpecifications() {
        return ResponseEntity.ok(specificationService.getAllSpecifications());
    }

    @GetMapping("/zxc{id}")
    public ResponseEntity<SpecificationDto> getSpecificationById(@PathVariable Integer id) {
        return ResponseEntity.ok(specificationService.getSpecificationById(id));
    }

    @PostMapping
    public ResponseEntity<SpecificationDto> addSpecification(@RequestBody SpecificationDto specificationDto) {
        return ResponseEntity.ok(specificationService.addSpecification(specificationDto));
    }

    @PutMapping
    public ResponseEntity<SpecificationDto> updateSpecification(@RequestBody SpecificationRequestToUpdate specificationRequestToUpdate) {
        return ResponseEntity.ok(specificationService.updateSpecification(specificationRequestToUpdate));
    }

}
