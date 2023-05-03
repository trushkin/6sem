package by.bsuir.coursework.car;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/addCar")
public class CarController {
    @Autowired
    CarService carService;
    @GetMapping("/")
    public String showAddCarPage(Model model){
        model.addAttribute("carDto", new CarDto());
        return "addCar";
    }
    @PostMapping
    public String addCar(Model model, @ModelAttribute CarDto carDto){
        carService.addCar(carDto);
        return "redirect:/";
    }
}
