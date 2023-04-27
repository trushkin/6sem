package by.bsuir.proddep.repository;

import by.bsuir.proddep.entity.Operation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperationRepository extends JpaRepository<Operation, Integer> {
}
