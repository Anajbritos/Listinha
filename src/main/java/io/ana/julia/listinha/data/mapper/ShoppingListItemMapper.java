package io.ana.julia.listinha.data.mapper;

import io.ana.julia.listinha.data.dto.ItemDto;
import io.ana.julia.listinha.data.dto.ShoppingListDto;
import io.ana.julia.listinha.data.dto.ShoppingListItemDto;
import io.ana.julia.listinha.data.entity.ItemEntity;
import io.ana.julia.listinha.data.entity.ShoppingListEntity;
import io.ana.julia.listinha.data.entity.ShoppingListItemEntity;
import org.springframework.stereotype.Component;

@Component
public class ShoppingListItemMapper {

    public ShoppingListItemDto toShoppingListItemDto(
            ShoppingListItemEntity shoppingListItemEntity,
            ItemDto itemDto,
            ShoppingListDto shoppingListDto) {
        return new ShoppingListItemDto(
                shoppingListItemEntity.getId(),
                itemDto,
                shoppingListDto);
    }

    public ShoppingListItemEntity toShoppingListItemEntity(
            ShoppingListEntity shoppingListEntity,
            ItemEntity itemEntity) {
        return new ShoppingListItemEntity(
                shoppingListEntity,
                itemEntity
        );
    }
}
