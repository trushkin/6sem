package by.bsuir.proddep.item;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {
    @Autowired
    private ItemRepository itemRepository;

    private final ItemMapper itemMapper;

    public List<ItemDto> getAllProducts() {
        return itemRepository.findItemsByType(ItemType.PRODUCT).stream().map(itemMapper::toItemDto).toList();
    }
    public List<ItemDto> getAllMaterials() {
        return itemRepository.findItemsByType(ItemType.MATERIAL).stream().map(itemMapper::toItemDto).toList();
    }

    public ItemDto addItem(ItemDto itemDto) {
        Item item = itemRepository.save(itemMapper.toItemEntity(itemDto));
        return itemMapper.toItemDto(item);
    }

    public ItemDto updateItem(ItemDto itemDto) {
        Item entityItem = itemMapper.toItemEntity(itemDto);
        Item updatedItem = itemRepository.save(entityItem);
        return itemMapper.toItemDto(updatedItem);
    }
}
