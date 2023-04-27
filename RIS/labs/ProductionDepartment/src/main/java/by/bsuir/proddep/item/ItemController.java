package by.bsuir.proddep.item;

import by.bsuir.proddep.item.ItemDto;
import by.bsuir.proddep.item.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/items")
@RequiredArgsConstructor
public class ItemController {
    @Autowired
    ItemService itemService;

    @GetMapping("/asdf")
    public ResponseEntity<List<ItemDto>> getAllMaterials() {
        return ResponseEntity.ok(itemService.getAllMaterials());
    }
    @GetMapping
    public ResponseEntity<List<ItemDto>> getAllProducts() {
        return ResponseEntity.ok(itemService.getAllProducts());
    }
    @PostMapping
    public ResponseEntity<ItemDto> addItem(@RequestBody ItemDto itemDto){
        return ResponseEntity.ok(itemService.addItem(itemDto));
    }
    @PutMapping
    public ResponseEntity<ItemDto> updateItem(@RequestBody ItemDto itemDto){
        return ResponseEntity.ok(itemService.updateItem(itemDto));
    }
}
