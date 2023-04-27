package by.bsuir.proddep.specification;

import by.bsuir.proddep.operation.Operation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SpecificationDto {
    private Integer id;
    private String name;
    private Integer itemId;
    private String startDate;
    private String endDate;
    private boolean active;
    private Set<Operation> operations;
    private Set<SpecItem> materials;
}
