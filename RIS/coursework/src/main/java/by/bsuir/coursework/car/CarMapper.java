package by.bsuir.coursework.car;

import by.bsuir.coursework.car.details.Brand;
import by.bsuir.coursework.car.details.EngineRepository;
import by.bsuir.coursework.car.details.EngineType;
import by.bsuir.coursework.car.details.Model;
import by.bsuir.coursework.car.details.TransmissionRepository;
import by.bsuir.coursework.car.details.TransmissionType;
import by.bsuir.coursework.car.details.TrunkRepository;
import by.bsuir.coursework.car.details.TrunkVolume;
import by.bsuir.coursework.car.details.VehicleRepository;
import by.bsuir.coursework.car.details.VehicleType;
import by.bsuir.coursework.car.search.CarSearchDto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CarMapper {
    @Autowired
    EngineRepository engineRepository;
    @Autowired
    TransmissionRepository transmissionRepository;
    @Autowired
    TrunkRepository trunkRepository;
    @Autowired
    VehicleRepository vehicleRepository;

    public CarSearchDto toCarSearchDto(Car car) {
        return CarSearchDto.builder()
                .id(car.getId())
                .brand(car.getModel().getBrand().getBrandName())
                .model(car.getModel().getModelName())
                .aircon(car.isAircon())
                .performance(car.getPerformance())
                .capacity(car.getCapacity())
                .fuelConsumption(car.getFuelConsumption())
                .pricePerDay(car.getPricePerDay())
                .vehicle(car.getVehicle().getType())
                .transmission(car.getTransmission().getType())
                .engine(car.getEngine().getType())
                .trunk(car.getTrunk().getVolume())
                .build();
    }

    public CarDto toCarDto(Car car) {
        return CarDto.builder()
                .id(car.getId())
                .aircon(car.isAircon())
                .performance(car.getPerformance())
                .capacity(car.getCapacity())
                .fuelConsumption(car.getFuelConsumption())
                .pricePerDay(car.getPricePerDay())
                .year(car.getYear())
                .mileage(car.getMileage())
                .plateNum(car.getPlateNum())
                .model(car.getModel().getModelName())
                .brand(car.getModel().getBrand().getBrandName())
                .vehicle(car.getVehicle().getType().name())
                .transmission(car.getTransmission().getType().name())
                .engine(car.getEngine().getType().name())
                .trunk(car.getTrunk().getVolume().name())
                .build();
    }

    public Car toCarEntity(CarDto carDto, Model model) {
        return Car.builder()
                .aircon(carDto.isAircon())
                .performance(carDto.getPerformance())
                .capacity(carDto.getCapacity())
                .fuelConsumption(carDto.getFuelConsumption())
                .pricePerDay(carDto.getPricePerDay())
                .year(carDto.getYear())
                .mileage(carDto.getMileage())
                .plateNum(carDto.getPlateNum())
                .vehicle(vehicleRepository.findByType(VehicleType.valueOf(carDto.getVehicle())))
                .transmission(transmissionRepository.findByType(TransmissionType.valueOf(carDto.getTransmission())))
                .engine(engineRepository.findByType(EngineType.valueOf(carDto.getEngine())))
                .trunk(trunkRepository.findByVolume(TrunkVolume.valueOf(carDto.getTrunk())))
                .model(model)
                .build();
    }
}
