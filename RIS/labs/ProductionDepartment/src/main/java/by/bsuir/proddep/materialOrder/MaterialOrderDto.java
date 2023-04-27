package by.bsuir.proddep.materialOrder;

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
public class MaterialOrderDto {
    private Integer id;
    private Integer itemId;
    private Integer employeeId;
    private Integer productionOrderId;
    private Integer quantity;
    private String status;
}
