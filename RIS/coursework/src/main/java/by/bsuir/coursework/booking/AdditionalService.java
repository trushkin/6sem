//package by.bsuir.coursework.booking;
//
//import jakarta.persistence.CascadeType;
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.EnumType;
//import jakarta.persistence.Enumerated;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.ManyToMany;
//import jakarta.persistence.Table;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//import java.util.Set;
//
//@Entity
//@Table(name = "additional_services")
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//public class AdditionalService {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer id;
//    @Column(name="service")
//    @Enumerated(EnumType.STRING)
//    private AdditionalServiceType serviceType;
//    @Column(name="price_per_day")
//    private Integer pricePerDay;
//    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "services")
//    private Set<Booking> bookings;
//}