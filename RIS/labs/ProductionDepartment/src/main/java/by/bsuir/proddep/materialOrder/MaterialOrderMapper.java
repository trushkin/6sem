package by.bsuir.proddep.materialOrder;

import by.bsuir.proddep.employee.EmployeeRepository;
import by.bsuir.proddep.item.ItemRepository;
import by.bsuir.proddep.productionOrder.ProductionOrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class MaterialOrderMapper {
    @Autowired
    ItemRepository itemRepository;
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    ProductionOrderRepository productionOrderRepository;

    public MaterialOrderDto toMaterialOrderDto(MaterialOrder materialOrder) {
        return MaterialOrderDto.builder()
                .id(materialOrder.getId())
                .quantity(materialOrder.getQuantity())
                .status(materialOrder.getStatus())
                .itemId(materialOrder.getItem().getId())
                .employeeId(materialOrder.getEmployee().getId())
                .productionOrderId(materialOrder.getProductionOrder().getId())
                .build();
    }

    public MaterialOrder toMaterialOrderEntity(MaterialOrderDto materialOrderDto) {
        return MaterialOrder.builder()
                .id(materialOrderDto.getId())
                .quantity(materialOrderDto.getQuantity())
                .status(materialOrderDto.getStatus())
                .item(itemRepository.findById(materialOrderDto.getItemId()).get())
                .employee(employeeRepository.findById(materialOrderDto.getEmployeeId()).get())
                .productionOrder(productionOrderRepository.findById(materialOrderDto.getProductionOrderId()).get())
                .build();
    }
}
