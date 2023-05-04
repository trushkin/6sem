package by.bsuir.coursework.car;

import by.bsuir.coursework.car.details.Brand;
import by.bsuir.coursework.car.details.BrandRepository;
import by.bsuir.coursework.car.details.EngineRepository;
import by.bsuir.coursework.car.details.EngineType;
import by.bsuir.coursework.car.details.Model;
import by.bsuir.coursework.car.details.ModelRepository;
import by.bsuir.coursework.car.details.TransmissionRepository;
import by.bsuir.coursework.car.details.TransmissionType;
import by.bsuir.coursework.car.details.TrunkRepository;
import by.bsuir.coursework.car.details.TrunkVolume;
import by.bsuir.coursework.car.details.VehicleRepository;
import by.bsuir.coursework.car.details.VehicleType;
import by.bsuir.coursework.car.search.CarFilter;
import by.bsuir.coursework.car.search.CarSearchDto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
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
    @Autowired
    EngineRepository engineRepository;
    @Autowired
    TransmissionRepository transmissionRepository;
    @Autowired
    TrunkRepository trunkRepository;
    @Autowired
    VehicleRepository vehicleRepository;
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

    public List<CarSearchDto> filterAvailableCars(LocalDate dateFrom, LocalDate dateTo, CarFilter filter) {
        String queryForAvailableCars = """
                select * from cars c1
                where not exists(select * from bookings b1
                inner join cars c2 on b1.car_id = c2.id
                where (b1.pickup_date BETWEEN :dateFrom and :dateTo 
                or
                b1.drop_date BETWEEN :dateFrom and :dateTo
                or
                (b1.pickup_date < :dateFrom and b1.drop_date > :dateTo))
                and c2.id = c1.id)
                """;
        if(!filter.getEngine().isBlank()){
            Integer engineId = engineRepository.findByType(EngineType.valueOf(filter.getEngine())).getId();
            queryForAvailableCars += " and c1.engine_id = ";
            queryForAvailableCars += engineId;
        }
        if(!filter.getTransmission().isBlank()){
            Integer transmissionId = transmissionRepository.findByType(TransmissionType.valueOf(filter.getTransmission())).getId();
            queryForAvailableCars += " and c1.transmission_id = ";
            queryForAvailableCars += transmissionId;
        }
        if(!filter.getTrunkVolume().isBlank()){
            Integer trunkId = trunkRepository.findByVolume(TrunkVolume.valueOf(filter.getTrunkVolume())).getId();
            queryForAvailableCars += " and c1.trunk_volume_id = ";
            queryForAvailableCars += trunkId;
        }
        if(!filter.getVehicleType().isBlank()){
            Integer vehicleId = vehicleRepository.findByType(VehicleType.valueOf(filter.getVehicleType())).getId();
            queryForAvailableCars += " and c1.vehicle_type_id = ";
            queryForAvailableCars += vehicleId;
        }
        if (filter.getPrice() != null){
            queryForAvailableCars += " and c1.price_per_day";
            queryForAvailableCars += filter.getPrice();
        }
        Query query = entityManager.createNativeQuery(queryForAvailableCars, Car.class);
        query.setParameter("dateFrom", dateFrom);
        query.setParameter("dateTo", dateFrom);
        List<Car> cars = query.getResultList();
        return cars.stream().map(carMapper::toCarSearchDto).toList();
    }
}
