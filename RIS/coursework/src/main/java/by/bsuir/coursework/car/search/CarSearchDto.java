package by.bsuir.coursework.car.search;

import by.bsuir.coursework.booking.Booking;
import by.bsuir.coursework.car.details.EngineType;
import by.bsuir.coursework.car.details.TransmissionType;
import by.bsuir.coursework.car.details.TrunkVolume;
import by.bsuir.coursework.car.details.VehicleType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class CarSearchDto {
    private Integer id;
    private String brand;
    private String model;
    private boolean aircon;
    private Integer performance;
    private Integer capacity;
    private Double fuelConsumption;
    private Integer pricePerDay;
    private VehicleType vehicle;
    private TransmissionType transmission;
    private EngineType engine;
    private TrunkVolume trunk;
    private List<Booking> bookings;

}
