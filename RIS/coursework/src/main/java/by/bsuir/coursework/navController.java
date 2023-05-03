package by.bsuir.coursework;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class navController {
    @GetMapping("/aboutUs")
    public String showAboutUs(){
        return "aboutUs";
    }
}
