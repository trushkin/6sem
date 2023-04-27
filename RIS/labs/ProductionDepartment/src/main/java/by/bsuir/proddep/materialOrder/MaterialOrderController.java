package by.bsuir.proddep.materialOrder;

import by.bsuir.proddep.employee.EmployeeDto;
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
@RequestMapping("/materialOrders")
@RequiredArgsConstructor
public class MaterialOrderController {
    @Autowired
    MaterialOrderService materialOrderService;
    @GetMapping
    public ResponseEntity<List<MaterialOrderDto>> getMaterialOrdersByEmployee(){
        return ResponseEntity.ok(materialOrderService.getMaterialOrdersByWorker());
    }
    @PostMapping
    public ResponseEntity<MaterialOrderDto> addMaterialOrder(@RequestBody MaterialOrderDto materialOrderDto){
        return ResponseEntity.ok(materialOrderService.addMaterialOrder(materialOrderDto));
    }
    @PutMapping
    public ResponseEntity<MaterialOrderDto> updateMaterialOrder(@RequestBody MaterialOrderRequestToUpdate materialOrderRequestToUpdate){
        return ResponseEntity.ok(materialOrderService.updateMaterialOrder(materialOrderRequestToUpdate));
    }

}
