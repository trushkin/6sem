package by.bsuir.proddep.specification;

import by.bsuir.proddep.item.Item;
import by.bsuir.proddep.operation.Operation;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "specification")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Specification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "start_date")
    private String startDate;
    @Column(name = "end_date")
    private String endDate;
    @OneToOne(cascade = CascadeType.ALL)
    private Item item;
    @OneToMany(cascade = CascadeType.ALL)
    private Set<SpecItem> specItems;
    @OneToMany(cascade = CascadeType.ALL)
    private Set<Operation> operations;
    private boolean active;
}
