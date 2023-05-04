package by.bsuir.coursework.booking;

import by.bsuir.coursework.user.UserDto;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;

@Controller
public class BookController {
    @Autowired
    BookingService bookingService;
    @GetMapping("/book/{id}")
    public String showBookingDetails(Model model, HttpSession session, @PathVariable Integer id) {
        UserDto userDto = (UserDto) session.getAttribute("user");
        LocalDate dateFrom = (LocalDate) session.getAttribute("dateFrom");
        LocalDate dateTo = (LocalDate) session.getAttribute("dateTo");
        BookingDtoToConfirm booking = bookingService.buildBookingToConfirm(id,userDto, dateFrom, dateTo);
        session.setAttribute("booking", booking);
        model.addAttribute("booking", booking);
        return "book";
    }
    @GetMapping("/confirmBooking")
    public String confirmBooking(HttpSession session){
        BookingDtoToConfirm booking = (BookingDtoToConfirm) session.getAttribute("booking");
        bookingService.addBooking(booking);
        return "index";
    }
}
