package by.bsuir.coursework.booking;

import by.bsuir.coursework.car.search.CarSearchDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CarBookController {
    @GetMapping("/book/{id}")
    public String showBookingDetails(Model model,@PathVariable Integer id){
        CarSearchDto car = new CarSearchDto(id, "vw", "golf"); // Поиск авто по id в бд
        model.addAttribute("car", car);
        return "book";
    }
}
