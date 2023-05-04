package by.bsuir.coursework.booking;

import by.bsuir.coursework.car.CarRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class BookingMapper {
    @Autowired
    CarRepository carRepository;
    public BookingDto toBookingDto(Booking booking){
        return BookingDto.builder()
                .id(booking.getId())
                .clientID(booking.getClient().getId())
                .clientName(booking.getClient().getUser().getName())
                .clientSurname(booking.getClient().getUser().getSurname())
                .clientPatronymic(booking.getClient().getUser().getPatronymic())
                .carID(booking.getCar().getId())
                .brand(booking.getCar().getModel().getBrand().getBrandName())
                .model(booking.getCar().getModel().getModelName())
                .price(booking.getPrice())
                .pickupDate(booking.getPickupDate())
                .dropDate(booking.getDropDate())
                .build();
    }
    public Booking toBookingEntity(BookingDtoToConfirm bookingDtoToConfirm){
        return Booking.builder()
                .price(bookingDtoToConfirm.getPrice())
                .pickupDate(bookingDtoToConfirm.getPickupDate())
                .dropDate(bookingDtoToConfirm.getDropDate())
                .client(bookingDtoToConfirm.getClient())
                .car(carRepository.findById(bookingDtoToConfirm.getCar().getId()).get())
                .build();
    }
}
