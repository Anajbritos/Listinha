package io.ana.julia.listinha.utils;

import io.ana.julia.listinha.data.dto.ShoppingListProductDto;
import io.ana.julia.listinha.data.entity.ShoppingListProductEntity;

public class DataFactoryShoppingListItem {

    public static ShoppingListProductDto shoppingListProductDto() {
        return new ShoppingListProductDto(
                1L,
                DataFactoryProduct.productDto(),
                DataFactoryShoppingList.listDto()
        );
    }

    public static ShoppingListProductEntity shoppingListProductEntity() {
        return new ShoppingListProductEntity(
                1L,
                DataFactoryProduct.productEntity(),
                DataFactoryShoppingList.listEntity()
        );
    }
}
