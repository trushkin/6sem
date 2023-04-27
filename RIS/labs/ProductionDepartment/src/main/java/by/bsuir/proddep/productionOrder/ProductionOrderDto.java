package by.bsuir.proddep.productionOrder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductionOrderDto {
    private Integer id;
    private Integer itemId;
    private Integer quantity;
    private String name;
    private String status;
}
