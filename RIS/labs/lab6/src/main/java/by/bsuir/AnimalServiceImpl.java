package by.bsuir;

import jakarta.jws.WebService;

import java.util.List;
@WebService(endpointInterface = "org.example.AnimalService", serviceName = "AnimalService")
public class AnimalServiceImpl implements AnimalService {
    private final AnimalRepository animalRepository;

    public AnimalServiceImpl(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }


    @Override
    public List<Animal> getAll() {
        return animalRepository.getAll();
    }

    @Override
    public List<Animal> getByFeed(String feed) {
        return animalRepository.getAllByFeed(feed);
    }

    @Override
    public List<Animal> getByAnimalName(String name) {
        return animalRepository.getAllByAnimalName(name);
    }
}
