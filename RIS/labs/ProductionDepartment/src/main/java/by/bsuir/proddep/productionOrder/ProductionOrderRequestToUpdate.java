package by.bsuir.proddep.productionOrder;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductionOrderRequestToUpdate {
    private Integer id;
    private String status;
}
