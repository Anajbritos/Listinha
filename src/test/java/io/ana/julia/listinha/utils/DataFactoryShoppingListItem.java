package io.ana.julia.listinha.utils;

import io.ana.julia.listinha.data.dto.ShoppingListItemDto;

public class DataFactoryShoppingListItem {

    public static ShoppingListItemDto shoppingListItemDto() {
        return new ShoppingListItemDto(
                1L,
                DataFactoryItem.itemDto(),
                DataFactoryShoppingList.listDto()
        );
    }
}
