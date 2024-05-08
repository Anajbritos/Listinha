package io.ana.julia.listinha.utils;
import io.ana.julia.listinha.data.dto.ListDto;
import io.ana.julia.listinha.data.dto.enumDto.PeriodTypeDto;
import io.ana.julia.listinha.data.entity.ListEntity;
import io.ana.julia.listinha.data.entity.enumEntity.PeriodTypeEntity;

import java.math.BigDecimal;
import java.time.LocalDate;

public class DataFactoryList {

    public static ListDto listDto() {
        return new ListDto(
                1L,
//                1L,
                "Lista Final de Semana",
                LocalDate.of(2024, 4, 1),
                PeriodTypeDto.DAILY,
                40,
                new BigDecimal("500")
        );
    }

    public static ListEntity listEntity() {
        return new ListEntity(
                1L,
//                1L,
                "Lista Final de Semana",
                LocalDate.of(2024, 4, 1),
                PeriodTypeEntity.DAILY,
                40,
                new BigDecimal("500")
        );
    }
}
