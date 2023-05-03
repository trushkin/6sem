package by.bsuir.coursework.car;

import by.bsuir.coursework.car.details.Brand;
import by.bsuir.coursework.car.details.BrandRepository;
import by.bsuir.coursework.car.details.Model;
import by.bsuir.coursework.car.details.ModelRepository;
import by.bsuir.coursework.car.search.CarSearchDto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CarService {
    @Autowired
    BrandRepository brandRepository;
    @Autowired
    ModelRepository modelRepository;
    @Autowired
    CarRepository carRepository;
    @Autowired
    CarMapper carMapper;

    @PersistenceContext
    private EntityManager entityManager;

    public void addCar(CarDto carDto) {
        Brand brand = new Brand();
        Model model = new Model();
        if (brandRepository.findByBrandName(carDto.getBrand()).isPresent()) {
            brand = brandRepository.findByBrandName(carDto.getBrand()).get();
        } else {
            brand = brandRepository.save(new Brand(carDto.getBrand()));
        }
        if (modelRepository.findByModelName(carDto.getModel()).isPresent()) {
            model = modelRepository.findByModelName(carDto.getModel()).get();
        } else {
            model = modelRepository.save(new Model(carDto.getModel(), brand));
        }
        carRepository.save(carMapper.toCarEntity(carDto, model));
    }

    public List<CarSearchDto> findAvailableCars(LocalDate dateFrom, LocalDate dateTo) {
        List<Car> cars = carRepository.findAvailableCars(dateFrom, dateTo);
        return cars.stream().map(carMapper::toCarSearchDto).toList();
    }

    public List<CarSearchDto> filterAvailableCars(LocalDate dateFrom, LocalDate dateTo) {
        List<Car> cars;
        Query query = entityManager.createNativeQuery("""
                select * from cars c1
                where not exists(select * from bookings b1
                inner join cars c2 on b1.car_id = c2.id
                where (b1.pickup_date BETWEEN :dateFrom and :dateTo 
                or
                b1.drop_date BETWEEN :dateFrom and :dateTo
                or
                (b1.pickup_date < :dateFrom and b1.drop_date > :dateTo))
                and c2.id = c1.id) and c1.transmission_id = 1 and c1.engine_id = 4
                """, Car.class);
        query.setParameter("dateFrom", dateFrom);
        query.setParameter("dateTo", dateFrom);
        cars = query.getResultList();
        return cars.stream().map(carMapper::toCarSearchDto).toList();
    }
}
