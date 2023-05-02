package by.bsuir.coursework.car;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/addCar")
public class CarController {
    @GetMapping("/")
    public String showAddCarPage(Model model){
        model.addAttribute("carDto", new CarDto());
        return "addCar";
    }
    @PostMapping
    public String addUser(Model model, @ModelAttribute CarDto carDto){
        CarDto carDto1 = carDto;
        return "redirect:/";
    }
}
