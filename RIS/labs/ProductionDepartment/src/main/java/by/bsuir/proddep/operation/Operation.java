package by.bsuir.proddep.operation;

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
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "specOperation")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Operation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "queue")
    private String queue;
    @Column(name = "time")
    private Integer time;
    @Column(name = "name")
    private String name;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "specification_id")
    private Specification specification;

}
