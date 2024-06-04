package io.ana.julia.listinha.utils;

import io.ana.julia.listinha.data.dto.ShoppingListItemDto;
import io.ana.julia.listinha.data.entity.ShoppingListItemEntity;

public class DataFactoryShoppingListItem {

    public static ShoppingListItemDto shoppingListItemDto() {
        return new ShoppingListItemDto(
                1L,
                DataFactoryItem.itemDto(),
                DataFactoryShoppingList.listDto()
        );
    }

    public static ShoppingListItemEntity shoppingListItemEntity() {
        return new ShoppingListItemEntity(
                1L,
                DataFactoryItem.itemEntity(),
                DataFactoryShoppingList.listEntity()
        );
    }
}
