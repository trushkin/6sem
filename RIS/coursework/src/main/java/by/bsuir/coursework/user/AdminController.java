package by.bsuir.coursework.user;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/users")
public class AdminController {
    @Autowired
    private UserService userService;

    @GetMapping("/admin")
    public String userList(Model model) {
        model.addAttribute("allUsers", userService.getAllUsers());
        return "admin";
    }

//    @PostMapping("/admin")
//    public String deleteUser(@RequestParam(required = true, defaultValue = "") Integer userId,
//                             @RequestParam(required = true, defaultValue = "") String action,
//                             Model model) {
//        if (action.equals("delete")) {
//            userService.deleteUser(userId);
//        }
//        return "redirect:/admin";
//    }
//public boolean deleteUser(Integer userId) {
//    if (userRepository.findById(userId).isPresent()) {
//        userRepository.deleteById(userId);
//        return true;
//    }
//    return false;
//}
    @GetMapping("/addUser")
    public String showAddUserPage(Model model){
        model.addAttribute("userDto", new UserDto());
        return "addUser";
    }
    @GetMapping("/delete/{id}")
    public String deleteUser(Model model, HttpSession session, @PathVariable Integer id){
        userService.deleteUser(id);
        return "redirect:/users/";
    }
    @PostMapping("/addUser")
    public String addUser(Model model, @ModelAttribute UserDto userDto){
        userDto.setPassword("111111");
        if (!userService.addClient(userDto)){
            model.addAttribute("error", "Пользователь с таким email уже существует");
            return "addUser";
        }
        return "redirect:/users/";
    }

    @GetMapping("/")
    public String getAllUsers(Model model) {
        List<UserDto> users = userService.getAllUsersByRole(UserRole.CLIENT);
        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping("/search")
    public String searchUsers(Model model, @RequestParam String keyword) {
        List<UserDto> users = new ArrayList<>();
        if (keyword.isBlank()) {
            users = userService.getAllUsersByRole(UserRole.CLIENT);
        } else {
            users = userService.getUsersByKeyword(keyword);
        }
        model.addAttribute("users", users);
        return "users";
    }

//    @GetMapping("/admin/gt/{userId}")
//    public String  gtUser(@PathVariable("userId") Long userId, Model model) {
//        model.addAttribute("allUsers", userService.usergtList(userId));
//        return "admin";
//    }
}
