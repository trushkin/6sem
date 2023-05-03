package by.bsuir.coursework.car.details;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EngineRepository extends JpaRepository<Engine, Integer> {
    Engine findByType(EngineType type);
}
