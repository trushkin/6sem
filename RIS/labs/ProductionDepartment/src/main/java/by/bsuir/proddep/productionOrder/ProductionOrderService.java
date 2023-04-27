package by.bsuir.proddep.productionOrder;

import by.bsuir.proddep.materialOrder.MaterialOrder;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductionOrderService {
    @Autowired
    private ProductionOrderRepository productionOrderRepository;
    private final ProductionOrderMapper productionOrderMapper;

    public ProductionOrderDto addProductionOrder(ProductionOrderDto productionOrderDto) {
        productionOrderDto.setStatus("PROCESSING");
        ProductionOrder productionOrder = productionOrderRepository.save(productionOrderMapper.toProductionOrderEntity(productionOrderDto));
        return productionOrderMapper.toProductionOrderDto(productionOrder);
    }

    public ProductionOrderDto updateProductionOrder(ProductionOrderRequestToUpdate productionOrderRequestToUpdate) {
        ProductionOrder entityProductionOrder = productionOrderRepository.findById(productionOrderRequestToUpdate.getId()).get();
        entityProductionOrder.setStatus(productionOrderRequestToUpdate.getStatus());
        ProductionOrder updatedProductionOrder = productionOrderRepository.save(entityProductionOrder);
        return productionOrderMapper.toProductionOrderDto(updatedProductionOrder);
    }

    public List<ProductionOrderDto> getAllProductionOrders() {
        return productionOrderRepository.findAllByOrderByIdDesc().stream().map(productionOrderMapper::toProductionOrderDto).toList();
    }

    public List<ProductionOrderDto> getProductionOrdersByStatus(String status) {
        return productionOrderRepository.findAllByStatus(status).stream().map(productionOrderMapper::toProductionOrderDto).toList();
    }

    public ProductionOrderDto getProductionOrdersById(Integer id) {
        return productionOrderMapper.toProductionOrderDto(productionOrderRepository.findById(id).get());
    }
}
