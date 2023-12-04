package by.bsuir.coursework.booking;

import by.bsuir.coursework.car.CarMapper;
import by.bsuir.coursework.car.CarRepository;
import by.bsuir.coursework.user.ClientRepository;
import by.bsuir.coursework.user.UserDto;
import by.bsuir.coursework.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingService {
    @Autowired
    CarRepository carRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    CarMapper carMapper;
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    BookingRepository bookingRepository;
    @Autowired
    BookingMapper bookingMapper;
    public BookingDtoToConfirm buildBookingToConfirm(Integer carId, UserDto userDto, LocalDate dateFrom, LocalDate dateTo){
     Integer clientId = userRepository.findByEmail(userDto.getEmail()).getClient().getId();

      return BookingDtoToConfirm.builder()
              .pickupDate(dateFrom)
              .dropDate(dateTo)
              .car(carMapper.toCarDto(carRepository.findById(carId).get()))
              .client(clientRepository.findById(clientId).get())
              .price((double) (carRepository.findById(carId).get().getPricePerDay() * (dateTo.getDayOfMonth() - dateFrom.getDayOfMonth())))
              .build();
    }
    public void deleteBooking(Integer bookingId){
        if (bookingRepository.findById(bookingId).isPresent()) {
            bookingRepository.deleteById(bookingId);
        }
    }

    public void addBooking(BookingDtoToConfirm bookingDtoToConfirm){
        Booking entity = bookingMapper.toBookingEntity(bookingDtoToConfirm);
        bookingRepository.save(entity);
    }
    public List<BookingDto> getAllBookings(){
        return bookingRepository.findAll().stream().map(bookingMapper::toBookingDto).toList();
    }
    public List<BookingDto> getBookingsByKeyword(String keyword){
        return bookingRepository.findByKeyword(keyword).stream().map(bookingMapper::toBookingDto).toList();
    }

}
