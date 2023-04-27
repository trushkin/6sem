package by.bsuir.proddep.dto.mapper;

import by.bsuir.proddep.dto.ItemDto;
import by.bsuir.proddep.entity.Item;
import by.bsuir.proddep.repository.SpecificationRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ItemMapper {
    @Autowired
    private final SpecificationRepository specificationRepository;
    public ItemDto toItemDto(Item item){
        return ItemDto.builder()
                .id(item.getId())
                .name(item.getName())
                .type(item.getType())
                .specificationId(item.getSpecification().getId())
                .build();
    }
    public Item toItemEntity(ItemDto itemDto){
        return Item.builder()
                .id(itemDto.getId())
                .name(itemDto.getName())
                .type(itemDto.getType())
                .specification(specificationRepository.findById(itemDto.getSpecificationId()).get())
                .build();
    }
}
