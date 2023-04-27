package by.bsuir.proddep.item;

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
public class ItemDto {
    private Integer id;
    private String name;
    private ItemType type;
    private Integer specificationId;
}
