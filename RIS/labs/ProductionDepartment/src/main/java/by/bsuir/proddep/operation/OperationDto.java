package by.bsuir.proddep.operation;

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
public class OperationDto {
    private Integer id;
    private String name;
    private String queue;
    private Integer time;
    private Integer specificationId;
}
