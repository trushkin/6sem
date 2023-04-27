package by.bsuir.proddep.materialOrder;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MaterialOrderRepository extends JpaRepository<MaterialOrder, Integer> {
    List<MaterialOrder> findByEmployee_Id(Integer id);
}
