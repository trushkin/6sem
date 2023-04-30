package by.bsuir.coursework.car.search;

import by.bsuir.coursework.car.details.EngineType;
import by.bsuir.coursework.car.details.TransmissionType;
import by.bsuir.coursework.car.details.TrunkVolume;
import by.bsuir.coursework.car.details.VehicleType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CarSearchController {
    @PostMapping("/searchForAvailableCars")
    public String searchForAvailableCars(Model model, @RequestParam LocalDate dateFrom, @RequestParam LocalDate dateTo) {
        model.addAttribute("dateFrom", dateFrom);
        model.addAttribute("dateTo", dateTo);
        List<CarSearchDto> cars = new ArrayList<>();
        cars.add(CarSearchDto.builder()
                        .id(1)
                        .brand("Volkswagen")
                        .model("Golf")
                        .aircon(true)
                        .capacity(4)
                        .engine(EngineType.GASOLINE)
                        .transmission(TransmissionType.AUTOMATED_MANUAL)
                        .performance(120)
                        .fuelConsumption(7.5)
                        .pricePerDay(45)
                        .trunk(TrunkVolume.ONE_LARGE_ONE_SMALL)
                        .vehicle(VehicleType.HATCHBACK)
                .build());
        cars.add(CarSearchDto.builder()
                        .id(2)
                        .brand("Ford")
                        .model("Focus")
                        .aircon(false)
                        .capacity(5)
                        .engine(EngineType.DIESEL)
                        .transmission(TransmissionType.MANUAL)
                        .performance(95)
                        .fuelConsumption(5.4)
                        .pricePerDay(35)
                        .trunk(TrunkVolume.TWO_LARGE)
                        .vehicle(VehicleType.WAGON)
                .build());
        model.addAttribute("cars", cars);
        return "carSearch";
    }
}
