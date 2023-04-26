package by.bsuir.coursework.booking;

import by.bsuir.coursework.car.search.CarSearchDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConfirmBookingController {
    @PostMapping("/confirmBooking")
    public String confirmBooking(Model model, @RequestParam Integer id){
        CarSearchDto car = new CarSearchDto(id, "vw", "golf"); // Поиск авто по id в бд
        model.addAttribute("car", car);
        return "confirmation";
    }
}