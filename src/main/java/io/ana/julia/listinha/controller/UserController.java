package io.ana.julia.listinha.controller;

import io.ana.julia.listinha.data.dto.ShoppingListDto;
import io.ana.julia.listinha.data.dto.ShoppingListItemDto;
import io.ana.julia.listinha.data.dto.UserDto;
import io.ana.julia.listinha.service.ShoppingListItemService;
import io.ana.julia.listinha.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final ShoppingListItemService shoppingListItemService;

    public UserController(
            UserService userService,
            ShoppingListItemService shoppingListItemService) {
        this.userService = userService;
        this.shoppingListItemService = shoppingListItemService;
    }

    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDTO) {
        UserDto createUserDto = userService.createUser(userDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createUserDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDTO) {
        UserDto updateUserDto = userService.updateUser(userDTO);
        return ResponseEntity.status(HttpStatus.OK).body(updateUserDto);
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> findAllUsers() {
        List<UserDto> findAllUsersDto = userService.findAllUsers();
        return ResponseEntity.status(HttpStatus.OK).body(findAllUsersDto);
    }

    @GetMapping("/{id}/shopping-lists")
    public ResponseEntity<List<ShoppingListDto>> getShoppingListByUser(
            @PathVariable("id") Long id) {
        List<ShoppingListDto> getListById = userService.getListsById(id);
        return ResponseEntity.status(HttpStatus.OK).body(getListById);
    }

    @PostMapping("/{userId}/shopping-lists/{shoppingListId}/itemm/{itemId}")
    public ResponseEntity<List<ShoppingListItemDto>> addShoppingListItem(
            @PathVariable("userId") Long userId,
            @PathVariable("shoppingListId") Long shoppingListId,
            @PathVariable("itemId") Long itemId
    ) {
        List<ShoppingListItemDto> body = shoppingListItemService.addItemOnShoppingList(
                userId, itemId, shoppingListId);
        return ResponseEntity.status(HttpStatus.OK).body(body);

    }

    @DeleteMapping("/shopping-lists/{shoppingListId}/item/{shoppingListItemId}")
    public ResponseEntity<List<ShoppingListItemDto>> deleteShoppingListItem(
            @PathVariable("shoppingListId") Long shoppingListId,
            @PathVariable("shoppingListItemId") Long shoppingListItemId
    ) {
        List<ShoppingListItemDto> body = shoppingListItemService.removeItemOnShoppingList(
                shoppingListItemId,
                shoppingListId);
        return ResponseEntity.status(HttpStatus.OK).body(body);
    }
}
