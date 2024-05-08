package io.ana.julia.listinha.controller;

import io.ana.julia.listinha.data.dto.ItemDto;
import io.ana.julia.listinha.service.ItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping("/create")
    public ResponseEntity<ItemDto> createItem(@RequestBody ItemDto itemDto) {
        ItemDto bodyDto = itemService.createItem(itemDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(bodyDto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable Long id) {
        itemService.deleteItem(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/update")
    public ResponseEntity<ItemDto> updateItem(@RequestBody ItemDto itemDto) {
        ItemDto bodyDto = itemService.updateItem(itemDto);
        return ResponseEntity.status(HttpStatus.OK).body(bodyDto);
    }

    @GetMapping("/find-all")
    public ResponseEntity<List<ItemDto>> findAllItems() {
        List<ItemDto> bodyDtos = itemService.findAllItems();
        return ResponseEntity.status(HttpStatus.OK).body(bodyDtos);
    }
}
