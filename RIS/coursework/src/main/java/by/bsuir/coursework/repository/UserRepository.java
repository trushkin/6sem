package by.bsuir.coursework.repository;

import by.bsuir.coursework.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByEmail(String name);
}
