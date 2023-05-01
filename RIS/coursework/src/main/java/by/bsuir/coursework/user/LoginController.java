package by.bsuir.coursework.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private UserService userService;
    @GetMapping
    public String showPage(){
        return "login";
    }
    @PostMapping()
    public String login(Model model, @RequestParam String email, @RequestParam String password) {
        return "index";
    }
}
