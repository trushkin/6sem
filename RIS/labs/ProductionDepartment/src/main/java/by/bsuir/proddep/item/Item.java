package by.bsuir.proddep.item;

import by.bsuir.proddep.materialOrder.MaterialOrder;
import by.bsuir.proddep.productionOrder.ProductionOrder;
import by.bsuir.proddep.specification.SpecItem;
import by.bsuir.proddep.specification.Specification;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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

import java.util.Set;

@Entity
@Table(name = "item")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="name")
    private String name;
    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private ItemType type;
    @OneToOne
    private Specification specification;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "item", optional = true)
    private ProductionOrder productionOrder;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "item")
    private Set<SpecItem> specItems;
    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL)
    private Set<MaterialOrder> materialOrders;

    

    public Item(String name, ItemType type) {
        this.name = name;
        this.type = type;
    }
}
