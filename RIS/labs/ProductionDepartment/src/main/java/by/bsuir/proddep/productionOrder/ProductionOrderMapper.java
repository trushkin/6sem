package by.bsuir.proddep.productionOrder;

import by.bsuir.proddep.item.ItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ProductionOrderMapper {
    @Autowired
    ItemRepository itemRepository;

    public ProductionOrderDto toProductionOrderDto(ProductionOrder productionOrder) {
        return ProductionOrderDto.builder()
                .id(productionOrder.getId())
                .itemId(productionOrder.getItem().getId())
                .status(productionOrder.getStatus())
                .name(productionOrder.getName())
                .quantity(productionOrder.getQuantity())
                .build();
    }

    public ProductionOrder toProductionOrderEntity(ProductionOrderDto productionOrderDto) {
        return ProductionOrder.builder()
                .id(productionOrderDto.getId())
                .item(itemRepository.findById(productionOrderDto.getId()).get())
                .status(productionOrderDto.getStatus())
                .name(productionOrderDto.getName())
                .quantity(productionOrderDto.getQuantity())
                .build();
    }
}
