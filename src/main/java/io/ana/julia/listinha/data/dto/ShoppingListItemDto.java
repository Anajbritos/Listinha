package io.ana.julia.listinha.data.dto;

import io.ana.julia.listinha.data.entity.ItemEntity;
import io.ana.julia.listinha.data.entity.ShoppingListEntity;
import jakarta.persistence.*;

public class ShoppingListItemDto {

    private Long id;

    private Long shoppingListId;

    private Long itemId;

    public ShoppingListItemDto(){}
    public ShoppingListItemDto(
            Long id,
            Long shoppingListId,
            Long itemId) {
        this.id = id;
        this.shoppingListId = shoppingListId;
        this.itemId = itemId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Long getShoppingListId() {
        return shoppingListId;
    }

    public void setShoppingListId(Long shoppingListId) {
        this.shoppingListId = shoppingListId;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }
}
