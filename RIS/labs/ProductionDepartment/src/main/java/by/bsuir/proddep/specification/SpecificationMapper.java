package by.bsuir.proddep.specification;

import by.bsuir.proddep.item.ItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class SpecificationMapper {
    @Autowired
    ItemRepository itemRepository;
    public SpecificationDto toSpecificationDto (Specification specification){
        return SpecificationDto.builder()
                .id(specification.getId())
                .name(specification.getName())
                .itemId(specification.getItem().getId())
                .startDate(specification.getStartDate())
                .endDate(specification.getEndDate())
                .active(specification.isActive())
                .materials(specification.getSpecItems())
                .operations(specification.getOperations())
                .build();
    }
    public Specification toSpecificationEntity(SpecificationDto specificationDto){
        return Specification.builder()
                .id(specificationDto.getId())
                .name(specificationDto.getName())
                .item(itemRepository.findById(specificationDto.getId()).get())
                .startDate(specificationDto.getStartDate())
                .endDate(specificationDto.getEndDate())
                .active(specificationDto.isActive())
                .specItems(specificationDto.getMaterials())
                .operations(specificationDto.getOperations())
                .build();
    }
}
