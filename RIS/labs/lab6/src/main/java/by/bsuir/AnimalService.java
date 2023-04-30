package by.bsuir;

import jakarta.jws.WebService;

import java.util.List;

@WebService
public interface AnimalService {
    List<Animal> getAll();

    List<Animal> getByFeed(String feed);

    List<Animal> getByAnimalName(String name);
}
