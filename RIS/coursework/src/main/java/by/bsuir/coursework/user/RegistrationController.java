package by.bsuir.coursework.user;


import jakarta.servlet.http.HttpSession;
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
    public String registration(Model model, HttpSession session, @ModelAttribute UserDto userDto){
        if (!userService.addClient(userDto, session)){
            model.addAttribute("error", "Пользователь с таким email уже существует");
            return "registration";
        }
        return "index";
    }

}
