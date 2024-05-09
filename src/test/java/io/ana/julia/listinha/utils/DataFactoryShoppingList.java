package io.ana.julia.listinha.utils;
import io.ana.julia.listinha.data.dto.ShoppingListDto;
import io.ana.julia.listinha.data.dto.UserDto;
import io.ana.julia.listinha.data.dto.enumDto.PeriodTypeDto;
import io.ana.julia.listinha.data.entity.ShoppingListEntity;
import io.ana.julia.listinha.data.entity.UserEntity;
import io.ana.julia.listinha.data.entity.enumEntity.PeriodTypeEntity;

import java.math.BigDecimal;
import java.time.LocalDate;

public class DataFactoryShoppingList {

    public static ShoppingListDto listDto() {

        return new ShoppingListDto(
                1L,
                1L,
                "Lista Final de Semana",
                LocalDate.of(2024, 4, 1),
                PeriodTypeDto.DAILY,
                40,
                new BigDecimal("500")
        );
    }

    public static ShoppingListEntity listEntity() {
        UserEntity user = new UserEntity();
        user.setId(1L);
        return new ShoppingListEntity(
                1L,
                user,
                "Lista Final de Semana",
                LocalDate.of(2024, 4, 1),
                PeriodTypeEntity.DAILY,
                40,
                new BigDecimal("500")
        );
    }
}
