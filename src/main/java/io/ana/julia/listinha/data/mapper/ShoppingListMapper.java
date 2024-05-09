package io.ana.julia.listinha.data.mapper;

import io.ana.julia.listinha.data.dto.ShoppingListDto;
import io.ana.julia.listinha.data.dto.UserDto;
import io.ana.julia.listinha.data.dto.enumDto.PeriodTypeDto;
import io.ana.julia.listinha.data.entity.ShoppingListEntity;
import io.ana.julia.listinha.data.entity.UserEntity;
import io.ana.julia.listinha.data.entity.enumEntity.PeriodTypeEntity;
import org.springframework.stereotype.Component;

@Component
public class ShoppingListMapper {


    public ShoppingListDto toListDTO(ShoppingListEntity shoppingListEntity) {

        return new ShoppingListDto(
                shoppingListEntity.getId(),
                shoppingListEntity.getUser().getId(),
                shoppingListEntity.getDescription(),
                shoppingListEntity.getDate(),
                toPeriodTypeDto(shoppingListEntity.getPeriodTypeEntity()),
                shoppingListEntity.getPeriod(),
                shoppingListEntity.getAmount()
        );
    }

    public ShoppingListEntity toListEntity(ShoppingListDto shoppingListDto, UserEntity userEntity) {
        return new ShoppingListEntity(
                shoppingListDto.getId(),
                userEntity,
                shoppingListDto.getDescription(),
                shoppingListDto.getDate(),
                toPeriodTypeEntity(shoppingListDto.getPeriodTypeDto()),
                shoppingListDto.getPeriod(),
                shoppingListDto.getAmount()
        );
    }


    public PeriodTypeDto toPeriodTypeDto(PeriodTypeEntity periodTypeEntity) {
        return switch (periodTypeEntity) {
            case MONTH -> PeriodTypeDto.MONTH;
            case WEEKLY -> PeriodTypeDto.WEEKLY;
            case DAILY -> PeriodTypeDto.DAILY;
        };
    }

    public PeriodTypeEntity toPeriodTypeEntity(PeriodTypeDto periodTypeDto) {
        return switch (periodTypeDto) {
            case MONTH -> PeriodTypeEntity.MONTH;
            case WEEKLY -> PeriodTypeEntity.WEEKLY;
            case DAILY -> PeriodTypeEntity.DAILY;
        };
    }
}
