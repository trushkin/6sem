package by.bsuir.coursework.user;

import by.bsuir.coursework.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByEmail(String name);

    List<User> findALLByRole(UserRole userRole);

    @Query("""
            select u from User u where u.name like %:keyword% or u.surname like %:keyword%
            or u.patronymic like %:keyword% or u.email like %:keyword%
            or u.client.address like %:keyword%
            or u.phoneNum like %:keyword%
            """)
    List<User> findByKeyword(String keyword);
}
