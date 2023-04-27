package by.bsuir.proddep.repository;

import by.bsuir.proddep.entity.Employee;
import by.bsuir.proddep.entity.Item;
import by.bsuir.proddep.entity.enums.ItemType;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Integer> {


    List<Item> findAll();

    List<Item> findItemsByType(ItemType type);
    List<Item> findByNameAndType(ItemType type, String name);
}
