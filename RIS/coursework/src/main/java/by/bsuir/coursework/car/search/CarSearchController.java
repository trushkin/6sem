package by.bsuir.coursework.car.search;

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
        cars.add(new CarSearchDto(1, "vw", "golf"));
        cars.add(new CarSearchDto(2, "vw", "golf"));
        model.addAttribute("cars", cars);
        return "carSearch";
    }
}
