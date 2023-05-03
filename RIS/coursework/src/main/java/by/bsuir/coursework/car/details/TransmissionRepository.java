package by.bsuir.coursework.car.details;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TransmissionRepository extends JpaRepository<Transmission, Integer> {
    Transmission findByType(TransmissionType type);
}
