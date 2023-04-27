package by.bsuir.proddep.materialOrder;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MaterialOrderRequestToUpdate {
    private Integer id;
    private String status;
}
