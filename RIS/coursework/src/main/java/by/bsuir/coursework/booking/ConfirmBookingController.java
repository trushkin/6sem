package by.bsuir.coursework.booking;

import by.bsuir.coursework.car.details.EngineType;
import by.bsuir.coursework.car.details.TransmissionType;
import by.bsuir.coursework.car.details.TrunkVolume;
import by.bsuir.coursework.car.details.VehicleType;
import by.bsuir.coursework.car.search.CarSearchDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConfirmBookingController {
    @PostMapping("/confirmBooking")
    public String confirmBooking(Model model, @RequestParam Integer id){
        CarSearchDto car = (CarSearchDto.builder()
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
                .build()); // Поиск авто по id в бд
        model.addAttribute("car", car);
        return "confirmation";
    }
}