package by.bsuir.coursework.booking;

import by.bsuir.coursework.car.CarDto;
import by.bsuir.coursework.user.Client;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class BookingDtoToConfirm {
    private Integer id;
    private Double price;
    private LocalDate pickupDate;
    private LocalDate dropDate;
    private Client client;
    private CarDto car;
}
