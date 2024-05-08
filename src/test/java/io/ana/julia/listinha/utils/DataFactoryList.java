package io.ana.julia.listinha.utils;

import io.ana.julia.listinha.data.dto.ItemDto;
import io.ana.julia.listinha.data.dto.ListDto;
import io.ana.julia.listinha.data.dto.enumDto.PeriodTypeDto;
import io.ana.julia.listinha.data.dto.enumDto.TypeItemDto;
import io.ana.julia.listinha.data.dto.enumDto.UnitOfMeasureItemDto;
import io.ana.julia.listinha.data.entity.ItemEntity;
import io.ana.julia.listinha.data.entity.ListEntity;
import io.ana.julia.listinha.data.entity.enumEntity.PeriodTypeEntity;
import io.ana.julia.listinha.data.entity.enumEntity.TypeItemEntity;
import io.ana.julia.listinha.data.entity.enumEntity.UnitOfMeasureItemEntity;

import java.math.BigDecimal;
import java.time.Period;
import java.util.Date;

public class DataFactoryList {

    public static ListDto listDto() {
        return new ListDto(
                1L,
                1L,
                "Lista Final de Semana",
                new Date(),
                PeriodTypeDto.DAILY,
                Period.ofDays(40),
                new BigDecimal("500")
        );
    }

    public static ListEntity listEntity() {
        return new ListEntity(
                1L,
                1L,
                "Lista Final de Semana",
                new Date(),
                PeriodTypeEntity.DAILY,
                Period.ofDays(40),
                new BigDecimal("500")
        );
    }
}
