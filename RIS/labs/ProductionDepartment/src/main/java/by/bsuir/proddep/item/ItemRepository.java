package by.bsuir.proddep.item;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Integer> {


    List<Item> findAll();

    List<Item> findItemsByType(ItemType type);
    List<Item> findByNameAndType(ItemType type, String name);
}
