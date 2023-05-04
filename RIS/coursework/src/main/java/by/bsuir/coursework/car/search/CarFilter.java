package by.bsuir.coursework.car.search;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
@AllArgsConstructor
@Getter
@Setter
public class CarFilter {
    private String engine;
    private String vehicleType;
    private String trunkVolume;
    private String transmission;
    private Integer price;
}
