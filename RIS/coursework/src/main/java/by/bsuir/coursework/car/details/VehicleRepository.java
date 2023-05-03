package by.bsuir.coursework.car.details;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {
    Vehicle findByType(VehicleType type);
}
