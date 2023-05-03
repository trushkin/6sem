package by.bsuir.coursework.booking;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class BookingDto {
    private Integer id;
    private Integer clientID;
    private String clientName;
    private String clientSurname;
    private String clientPatronymic;
    private Integer carID;
    private String brand;
    private String model;
    private Double price;
    private LocalDate pickupDate;
    private LocalDate dropDate;
    private String status;
}
