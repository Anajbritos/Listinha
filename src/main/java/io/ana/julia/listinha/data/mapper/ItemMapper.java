package io.ana.julia.listinha.data.mapper;

import io.ana.julia.listinha.data.dto.ItemDto;
import io.ana.julia.listinha.data.dto.enumDto.TypeItemDto;
import io.ana.julia.listinha.data.dto.enumDto.UnitOfMeasureItemDto;
import io.ana.julia.listinha.data.entity.ItemEntity;
import io.ana.julia.listinha.data.entity.enumEntity.TypeItemEntity;
import io.ana.julia.listinha.data.entity.enumEntity.UnitOfMeasureItemEntity;
import org.springframework.stereotype.Component;

@Component
public class ItemMapper {

    public ItemDto toItemDTO(ItemEntity itemEntity){
        return new ItemDto(
                itemEntity.getId(),
                itemEntity.getDescription(),
                toTypeItemDto(itemEntity.getTypeItemEntity()),
                toMeasureItemDto(itemEntity.getItemMeasurementEntity()),
                itemEntity.getPrice()
        );
    }

    public ItemEntity toItemEntity(ItemDto itemDto){
        return new ItemEntity(
                itemDto.getId() ,
                itemDto.getDescription(),
                toTypeItemEntity(itemDto.getTypeItemDto()),
                toMeasureItemEntity(itemDto.getItemMeasurementDto()),
                itemDto.getPrice()
        );
    }

    public TypeItemDto toTypeItemDto(TypeItemEntity typeItemEntity) {
        return switch (typeItemEntity) {
            case FRUIT -> TypeItemDto.FRUIT;
            case VEGETABLE -> TypeItemDto.VEGETABLE;
            case MEAT -> TypeItemDto.MEAT;
            case DAIRY -> TypeItemDto.DAIRY;
            case GRAIN -> TypeItemDto.GRAIN;
            case SNACK -> TypeItemDto.SNACK;
            case BEVERAGE -> TypeItemDto.BEVERAGE;
            case OTHER -> TypeItemDto.OTHER;
        };
    }

    public TypeItemEntity toTypeItemEntity(TypeItemDto typeItemDto) {
        return switch (typeItemDto) {
            case FRUIT -> TypeItemEntity.FRUIT;
            case VEGETABLE -> TypeItemEntity.VEGETABLE;
            case MEAT -> TypeItemEntity.MEAT;
            case DAIRY -> TypeItemEntity.DAIRY;
            case GRAIN -> TypeItemEntity.GRAIN;
            case SNACK -> TypeItemEntity.SNACK;
            case BEVERAGE -> TypeItemEntity.BEVERAGE;
            case OTHER -> TypeItemEntity.OTHER;
        };
    }

    public UnitOfMeasureItemDto toMeasureItemDto(UnitOfMeasureItemEntity unitOfMeasureItemEntity) {
        return switch (unitOfMeasureItemEntity) {
            case GRAM -> UnitOfMeasureItemDto.GRAM;
            case KILOGRAM -> UnitOfMeasureItemDto.KILOGRAM;
            case LITER -> UnitOfMeasureItemDto.LITER;
            case MILLILITER -> UnitOfMeasureItemDto.MILLILITER;
            case PIECE -> UnitOfMeasureItemDto.PIECE;
            case PACK -> UnitOfMeasureItemDto.PACK;
            case BOX -> UnitOfMeasureItemDto.BOX;
            case BOTTLE -> UnitOfMeasureItemDto.BOTTLE;
            case CAN -> UnitOfMeasureItemDto.CAN;
            case DOZEN -> UnitOfMeasureItemDto.DOZEN;
        };
    }

    public UnitOfMeasureItemEntity toMeasureItemEntity(UnitOfMeasureItemDto unitOfMeasureItemDto) {
        return switch (unitOfMeasureItemDto) {
            case GRAM -> UnitOfMeasureItemEntity.GRAM;
            case KILOGRAM -> UnitOfMeasureItemEntity.KILOGRAM;
            case LITER -> UnitOfMeasureItemEntity.LITER;
            case MILLILITER -> UnitOfMeasureItemEntity.MILLILITER;
            case PIECE -> UnitOfMeasureItemEntity.PIECE;
            case PACK -> UnitOfMeasureItemEntity.PACK;
            case BOX -> UnitOfMeasureItemEntity.BOX;
            case BOTTLE -> UnitOfMeasureItemEntity.BOTTLE;
            case CAN -> UnitOfMeasureItemEntity.CAN;
            case DOZEN -> UnitOfMeasureItemEntity.DOZEN;
        };
    }
}
