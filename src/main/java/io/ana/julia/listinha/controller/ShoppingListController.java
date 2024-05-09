package io.ana.julia.listinha.controller;

import io.ana.julia.listinha.data.dto.ShoppingListDto;
import io.ana.julia.listinha.service.ShoppingListService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shopping-lists")
public class ShoppingListController {

    private ShoppingListService shoppingListService;

    public ShoppingListController(ShoppingListService shoppingListService) {
        this.shoppingListService = shoppingListService;
    }

    @PostMapping("/create")
    public ResponseEntity<ShoppingListDto> createList(@RequestBody ShoppingListDto shoppingListDto) {
        ShoppingListDto requestBody = shoppingListService.createList(shoppingListDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(requestBody);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteList(@PathVariable Long id) {
        shoppingListService.deleteList(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    @PutMapping("/update")
    public ResponseEntity<ShoppingListDto> updateList(@RequestBody ShoppingListDto shoppingListDto) {
        ShoppingListDto requestBody = shoppingListService.updateList(shoppingListDto);
        return ResponseEntity.status(HttpStatus.OK).body(requestBody);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ShoppingListDto>> findAllList() {
        List<ShoppingListDto> requestBody = shoppingListService.findAllLists();
        return ResponseEntity.status(HttpStatus.OK).body(requestBody);
    }
}
