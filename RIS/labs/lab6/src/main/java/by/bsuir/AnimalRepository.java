package by.bsuir;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class AnimalRepository {
    private static int id = 0;
    private static List<Animal> staffList;

    static {
        staffList = List.of(
                        Animal.builder()
                                .id(++id)
                                .name("Chicken")
                                .quantity(12)
                                .feed("millet")
                                .build(),
                        Animal.builder()
                                .id(++id)
                                .name("Goose")
                                .quantity(4)
                                .feed("millet")
                                .build(),
                        Animal.builder()
                                .id(++id)
                                .name("Pig")
                                .quantity(3)
                                .feed("potato")
                                .build(),
                        Animal.builder()
                                .id(++id)
                                .name("Pig")
                                .quantity(3)
                                .feed("corn")
                                .build(),
                        Animal.builder()
                                .id(++id)
                                .name("Cow")
                                .quantity(2)
                                .feed("hay")
                                .build(),
                        Animal.builder()
                                .id(++id)
                                .name("Dog")
                                .quantity(1)
                                .feed("meat")
                                .build()

        );
    }


    public List<Animal> getAll() {
        return staffList;
    }

    public List<Animal> getAllByAnimalName(String animalName) {
        return staffList
                .stream()
                .filter(animal -> Objects.equals(animalName, animal.getName()))
                .collect(Collectors.toList());
    }

    public List<Animal> getAllByFeed(String feed) {
        return staffList
                .stream()
                .filter(animal -> Objects.equals(feed, animal.getFeed()))
                .collect(Collectors.toList());
    }
}
