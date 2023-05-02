package by.bsuir.coursework.user;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/profile")
public class ProfileController {
    @Autowired
    private UserService userService;
    @GetMapping
    public String showPage(){
        return "profile";
    }
    @PostMapping
    public String login(Model model, HttpSession session, @RequestParam String oldPassword, @RequestParam String newPassword) {
        return "index";
    }
}
