package by.bsuir.proddep.specification;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpecificationRepository extends JpaRepository<Specification, Integer> {
 List<Specification> findAllByOrderByIdDesc();
}
