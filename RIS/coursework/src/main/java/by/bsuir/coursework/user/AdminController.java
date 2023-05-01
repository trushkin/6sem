package by.bsuir.coursework.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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

    @PostMapping("/admin")
    public String deleteUser(@RequestParam(required = true, defaultValue = "") Integer userId,
                             @RequestParam(required = true, defaultValue = "") String action,
                             Model model) {
        if (action.equals("delete")) {
            userService.deleteUser(userId);
        }
        return "redirect:/admin";
    }
    @GetMapping("/addUser")
    public String showAddUserPage(Model model){
        model.addAttribute("userDto", new UserDto());
        return "addUser";
    }
    @PostMapping("/addUser")
    public String addUser(Model model, @ModelAttribute UserDto userDto){
        UserDto temp = userDto;
        // установить роль CLIENT
        // пароль по дефолту 123456
        System.out.println("ad");
        return "redirect:/users/";
    }

    @GetMapping("/")
    public String getAllUsers(Model model) {
//        List<UserDto> users = new ArrayList<>();
//        users.add(UserDto.builder()
//                        .id(1)
//                        .password("password")
//                        .name("Vasya")
//                        .surname("Pupkin")
//                        .patronymic("Petrovich")
//                        .phoneNum("+375297856452")
//                        .email("qwe.tter@mail.com")
//                        .role(UserRole.CLIENT)
//                        .age(22)
//                        .driving_exp(2)
//                        .passport("PASSPORT")
//                        .address("Петра Мстиславца 3-94")
//                .build());
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
