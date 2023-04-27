package by.bsuir.proddep.entity;

import by.bsuir.proddep.employee.Employee;
import by.bsuir.proddep.item.Item;
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
@Table(name = "material_order")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MaterialOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "isDone")
    private boolean isDone;
    @Column(name = "quantity")
    private Integer quantity;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "item_id")
    private Item item;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id")
    private Employee employee;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "production_order_id")
    private ProductionOrder productionOrder;
}
