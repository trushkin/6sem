package by.bsuir.proddep.productionOrder;

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
@RequestMapping("/productionOrders")
@RequiredArgsConstructor
public class ProductionOrderController {
    @Autowired
    ProductionOrderService productionOrderService;

    @GetMapping("/asd{id}")
    public ResponseEntity<ProductionOrderDto> getProductionOrderById(@PathVariable Integer id) {
        return ResponseEntity.ok(productionOrderService.getProductionOrdersById(id));
    }

    @GetMapping("/as{status}")
    public ResponseEntity<List<ProductionOrderDto>> getProductionOrdersByStatus(@PathVariable String status) {
        return ResponseEntity.ok(productionOrderService.getProductionOrdersByStatus(status));
    }

    @GetMapping("/xxx")
    public ResponseEntity<List<ProductionOrderDto>> getAllProductionOrders() {
        return ResponseEntity.ok(productionOrderService.getAllProductionOrders());
    }

    @PostMapping
    public ResponseEntity<ProductionOrderDto> addProductionOrder(@RequestBody ProductionOrderDto productionOrderDto) {
        return ResponseEntity.ok(productionOrderService.addProductionOrder(productionOrderDto));
    }

    @PutMapping("/sdf")
    public ResponseEntity<ProductionOrderDto> updateProductionOrder(@RequestBody ProductionOrderRequestToUpdate productionOrderRequestToUpdate) {
        return ResponseEntity.ok(productionOrderService.updateProductionOrder(productionOrderRequestToUpdate));
    }
}

