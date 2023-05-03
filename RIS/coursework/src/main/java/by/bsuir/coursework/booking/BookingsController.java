package by.bsuir.coursework.booking;

import by.bsuir.coursework.user.UserDto;
import by.bsuir.coursework.user.UserRole;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/bookings")
public class BookingsController {
    @GetMapping("/")
    public String getAllUsers(Model model) {
        List<BookingDto> bookingDtoList = new ArrayList<>();
        bookingDtoList.add(BookingDto.builder()
                        .brand("Honda")
                        .model("CRZ")
                        .clientSurname("Сидоров")
                        .clientName("Иван")
                        .clientPatronymic("Петрович")
                        .pickupDate(LocalDate.now())
                        .dropDate(LocalDate.of(2023, 5, 6))
                        .price(150.0)
                .build());
        model.addAttribute("bookings", bookingDtoList);
        return "bookings";
    }
    @GetMapping("/search")
    public String searchBookings(Model model, @RequestParam String keyword) {
        List<BookingDto> bookingDtoList = new ArrayList<>();
//        if (keyword.isBlank()) {
//            users = userService.getAllUsersByRole(UserRole.CLIENT);
//        } else {
//            users = userService.getUsersByKeyword(keyword);
//        }
        model.addAttribute("bookings", bookingDtoList);
        return "bookings";
    }

}
