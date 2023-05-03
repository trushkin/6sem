package by.bsuir.coursework.car.details;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TrunkRepository extends JpaRepository<Trunk, Integer> {
    Trunk findByVolume(TrunkVolume trunkVolume);
}
