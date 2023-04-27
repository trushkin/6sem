package by.bsuir.proddep.productionOrder;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductionOrderRepository extends JpaRepository<ProductionOrder, Integer> {
    List<ProductionOrder> findAllByOrderByIdDesc();
    List<ProductionOrder> findAllByStatus(String status);
}
