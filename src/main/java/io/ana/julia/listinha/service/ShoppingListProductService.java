package io.ana.julia.listinha.service;

import io.ana.julia.listinha.data.dto.ShoppingListItemDto;

import java.util.List;

public interface ShoppingListItemService {

    public List<ShoppingListItemDto> addItemOnShoppingList(Long userId, Long itemId, Long shoppingListId);

    public List<ShoppingListItemDto> removeItemOnShoppingList(Long shoppingListItemId, Long shoppingListId);
}
