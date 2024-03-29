package by.bsuir.coursework.car;

import by.bsuir.coursework.car.details.Engine;
import by.bsuir.coursework.car.details.Model;
import by.bsuir.coursework.car.details.Transmission;
import by.bsuir.coursework.car.details.Trunk;
import by.bsuir.coursework.car.details.Vehicle;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CarDto {
    private Integer id;
    private boolean aircon;
    private Integer performance;
    private Integer capacity;
    private Double fuelConsumption;
    private Integer pricePerDay;
    private Integer year;
    private Integer mileage;
    private Integer plateNum;
    private String model;
    private String brand;
    private String vehicle;
    private String transmission;
    private String engine;
    private String trunk;


}
