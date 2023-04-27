package by.bsuir.proddep.productionOrder;

import by.bsuir.proddep.materialOrder.MaterialOrder;
import by.bsuir.proddep.item.Item;
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

import java.util.Set;

@Entity
@Table(name = "production_order")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductionOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name="po_quantity")
    private Integer quantity;
    @Column(name = "status")
    private String status;
    @OneToMany(mappedBy = "productionOrder", cascade = CascadeType.ALL)
    private Set<MaterialOrder> materialOrders;
    @OneToOne(cascade = CascadeType.ALL)
    private Item item;
}
