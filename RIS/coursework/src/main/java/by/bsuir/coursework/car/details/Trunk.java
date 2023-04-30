package by.bsuir.coursework.car.details;

import by.bsuir.coursework.car.Car;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "trunks")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Trunk {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "volume")
    @Enumerated(EnumType.STRING)
    private TrunkVolume volume;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "trunk")
    private List<Car> cars;
}
