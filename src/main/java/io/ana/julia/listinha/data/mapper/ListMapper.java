package io.ana.julia.listinha.data.mapper;

import io.ana.julia.listinha.data.dto.ItemDto;
import io.ana.julia.listinha.data.dto.ListDto;
import io.ana.julia.listinha.data.dto.enumDto.PeriodTypeDto;
import io.ana.julia.listinha.data.dto.enumDto.TypeItemDto;
import io.ana.julia.listinha.data.entity.ItemEntity;
import io.ana.julia.listinha.data.entity.ListEntity;
import io.ana.julia.listinha.data.entity.enumEntity.PeriodTypeEntity;
import io.ana.julia.listinha.data.entity.enumEntity.TypeItemEntity;
import org.springframework.stereotype.Component;

@Component
public class ListMapper {

    public ListDto toListDTO(ListEntity listEntity) {
        return new ListDto(
                listEntity.getId(),
                listEntity.getIdUser(),
                listEntity.getDescription(),
                listEntity.getDate(),
                toPeriodTypeDto(listEntity.getPeriodTypeEntity()),
                listEntity.getPeriod(),
                listEntity.getAmount()
        );
    }

    public ListEntity toListEntity(ListDto listDto) {
        return new ListEntity(
                listDto.getId(),
                listDto.getIdUser(),
                listDto.getDescription(),
                listDto.getDate(),
                toPeriodTypeEntity(listDto.getPeriodTypeDto()),
                listDto.getPeriod(),
                listDto.getAmount()
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
