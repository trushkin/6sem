package by.bsuir.coursework.car;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface CarRepository extends JpaRepository<Car, Integer> {

    @Query(nativeQuery = true, value = """
            select * from cars c1
            where not exists(select * from bookings b1
            inner join cars c2 on b1.car_id = c2.id
            where (b1.pickup_date BETWEEN :dateFrom and :dateTo 
            or
            b1.drop_date BETWEEN :dateFrom and :dateTo
            or
            (b1.pickup_date < :dateFrom and b1.drop_date > :dateTo))
            and c2.id = c1.id) 
            """)
    List<Car> findAvailableCars(LocalDate dateFrom, LocalDate dateTo);
}
