package by.bsuir.coursework.booking;

import by.bsuir.coursework.user.UserDto;
import by.bsuir.coursework.user.UserRole;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/bookings")
public class BookingsController {
    @Autowired
    BookingService bookingService;
    @GetMapping("/")
    public String getAllUsers(Model model) {
        List<BookingDto> bookingDtoList = bookingService.getAllBookings();
        model.addAttribute("bookings", bookingDtoList);
        return "bookings";
    }
    @GetMapping("/search")
    public String searchBookings(Model model, @RequestParam String keyword) {
        List<BookingDto> bookingDtoList;
        if (keyword.isBlank()) {
            bookingDtoList = bookingService.getAllBookings();
        } else {
            bookingDtoList = bookingService.getBookingsByKeyword(keyword);
        }
        model.addAttribute("bookings", bookingDtoList);
        return "bookings";
    }
    @GetMapping("/delete/{id}")
    public String deleteUser(Model model, HttpSession session, @PathVariable Integer id){
        bookingService.deleteBooking(id);
        return "redirect:/bookings/";
    }

}
