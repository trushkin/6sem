package by.bsuir.coursework.car.search;

import by.bsuir.coursework.car.CarService;
import by.bsuir.coursework.car.details.EngineType;
import by.bsuir.coursework.car.details.TransmissionType;
import by.bsuir.coursework.car.details.TrunkVolume;
import by.bsuir.coursework.car.details.VehicleType;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CarSearchController {
    @Autowired
    CarService carService;
//    @GetMapping("/searchForAvailableCars")
//    public String showAvailableCarsPage(Model model) {
//        List<CarSearchDto> cars = carService.findAvailableCars((LocalDate) model.getAttribute("dateFrom"), (LocalDate) model.getAttribute("dateTo"));
//        model.addAttribute("cars", cars);
//        return "carSearch";
//    }
    @PostMapping("/searchForAvailableCars")
    public String searchForAvailableCars(Model model, HttpSession session, @RequestParam LocalDate dateFrom, @RequestParam LocalDate dateTo) {
        model.addAttribute("dateFrom", dateFrom);
        model.addAttribute("dateTo", dateTo);
        session.setAttribute("dateFrom", dateFrom);
        session.setAttribute("dateTo", dateTo);
        List<CarSearchDto> cars = carService.findAvailableCars(dateFrom, dateTo);
        model.addAttribute("cars", cars);
        return "carSearch";
    }

    @PostMapping("/filterAvailableCars")
    public String filterAvailableCars(Model model, HttpSession session, @RequestParam String engine, @RequestParam String vehicleType,
                                      @RequestParam String trunkVolume, @RequestParam String transmission, @RequestParam String price) {
        CarFilter carFilter;
        if (price.isBlank()) {
            carFilter = new CarFilter(engine, vehicleType, trunkVolume, transmission, null);
        } else {
            carFilter = new CarFilter(engine, vehicleType, trunkVolume, transmission, Integer.parseInt(price));
        }
        List<CarSearchDto> cars = carService.filterAvailableCars((LocalDate) session.getAttribute("dateFrom"), (LocalDate) session.getAttribute("dateTo"), carFilter);
        model.addAttribute("cars", cars);
        return "carSearch";
    }
}
