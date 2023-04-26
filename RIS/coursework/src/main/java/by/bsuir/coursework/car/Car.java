
package by.bsuir.coursework.car;

import by.bsuir.coursework.booking.Booking;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "cars")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="aircon")
    private boolean aircon;
    @Column(name="performance")
    private Integer performance;
    @Column(name="capacity")
    private Integer capacity;
    @Column(name="fuel_consumption")
    private Double fuelConsumption;
    @Column(name="price_per_day")
    private Integer pricePerDay;
    @Column(name="year")
    private Integer year;
    @Column(name="mileage")
    private Integer mileage;
    @Column(name="vin")
    private String vin;
    @Column(name="plate_num")
    private Integer plateNum;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "car", optional = true)
    private Booking booking;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "model_id")
    private Model model;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "vehicle_type_id")
    private Vehicle vehicle;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "transmission_id")
    private Transmission transmission;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "engine_id")
    private Engine engine;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "trunk_volume_id")
    private Trunk trunk;


}
