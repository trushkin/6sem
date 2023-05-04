package by.bsuir.coursework.booking;

import by.bsuir.coursework.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Integer> {
    @Query("""
            select b from Booking b where b.client.user.name like %:keyword% or b.client.user.surname like %:keyword%
            or b.client.user.patronymic like %:keyword% or b.car.model.modelName like %:keyword%
            or b.car.model.brand.brandName like %:keyword%
            """)
    List<Booking> findByKeyword(String keyword);
}
