package io.ana.julia.listinha.utils;

import io.ana.julia.listinha.data.dto.ItemDto;
import io.ana.julia.listinha.data.dto.UserDto;
import io.ana.julia.listinha.data.dto.enumDto.TypeItemDto;
import io.ana.julia.listinha.data.dto.enumDto.UnitOfMeasureItemDto;
import io.ana.julia.listinha.data.entity.ItemEntity;
import io.ana.julia.listinha.data.entity.UserEntity;
import io.ana.julia.listinha.data.entity.enumEntity.TypeItemEntity;
import io.ana.julia.listinha.data.entity.enumEntity.UnitOfMeasureItemEntity;

import java.math.BigDecimal;

public class DataFactoryItem {

    public static ItemDto itemDto() {
        return new ItemDto(
                1L,
                "Leite Longa Vida",
                TypeItemDto.DAIRY,
                UnitOfMeasureItemDto.BOTTLE,
                new BigDecimal("4.99"));
    }

    public static ItemEntity itemEntity() {
        return new ItemEntity(
                1L,
                "Leite Longa Vida",
                TypeItemEntity.DAIRY,
                UnitOfMeasureItemEntity.BOTTLE,
                new BigDecimal("4.99"));
    }
}
