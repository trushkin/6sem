package by.bsuir.proddep.specification;

import by.bsuir.proddep.item.Item;
import by.bsuir.proddep.specification.Specification;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "specItem")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SpecItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "sc_quantity")
    private Integer sc_quantity;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "item_id")
    private Item item;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "specification_id")
    private Specification specification;
}
