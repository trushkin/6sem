package by.bsuir.coursework.user;


import org.hibernate.annotations.GeneratorType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class RegistrationController {
    @Autowired
    UserService userService;

    @GetMapping
    public String showPage(Model model){
        model.addAttribute("userDto", new UserDto());
        return "registration";
    }
    @PostMapping
    public String registration(Model model, @ModelAttribute UserDto userDto){
        return "index";
    }

}
