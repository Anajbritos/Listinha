package io.ana.julia.listinha.data.mapper;

import io.ana.julia.listinha.data.dto.ProductDto;
import io.ana.julia.listinha.data.dto.ShoppingListDto;
import io.ana.julia.listinha.data.dto.ShoppingListProductDto;
import io.ana.julia.listinha.data.entity.ProductEntity;
import io.ana.julia.listinha.data.entity.ShoppingListEntity;
import io.ana.julia.listinha.data.entity.ShoppingListProductEntity;
import org.springframework.stereotype.Component;

@Component
public class ShoppingListItemMapper {

    public ShoppingListProductDto toShoppingListItemDto(
            ShoppingListProductEntity shoppingListProductEntity,
            ProductDto productDto,
            ShoppingListDto shoppingListDto) {
        return new ShoppingListProductDto(
                shoppingListProductEntity.getId(),
                productDto,
                shoppingListDto);
    }

    public ShoppingListProductEntity toShoppingListItemEntity(
            ShoppingListEntity shoppingListEntity,
            ProductEntity productEntity) {
        return new ShoppingListProductEntity(
                shoppingListEntity,
                productEntity
        );
    }
}
