package by.bsuir.proddep.entity;

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
@Table(name = "specOperation")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SpecOperation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "queue")
    private String queue;
    @Column(name = "time")
    private Integer time;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "operation_id")
    private Operation operation;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "specification_id")
    private Specification specification;

}
