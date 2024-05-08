package io.ana.julia.listinha.utils;

import io.ana.julia.listinha.data.dto.ItemDto;
import io.ana.julia.listinha.data.dto.ListDto;
import io.ana.julia.listinha.data.entity.ItemEntity;
import io.ana.julia.listinha.data.entity.ListEntity;
import org.junit.jupiter.api.Assertions;

public class AssertionListData {

    public static void assertMapperListDTO(ListDto listDto, ListEntity listEntity) {
        Assertions.assertEquals(listDto.getId(), listEntity.getId());
        Assertions.assertEquals(listDto.getIdUser(), listEntity.getIdUser());
        Assertions.assertEquals(listDto.getDescription(), listEntity.getDescription());
        Assertions.assertEquals(listDto.getDate(), listEntity.getDate());
        Assertions.assertEquals(listDto.getPeriodTypeDto().name(), listEntity.getPeriodTypeEntity().name());
        Assertions.assertEquals(listDto.getPeriod(), listEntity.getPeriod());
        Assertions.assertEquals(listDto.getAmount(), listEntity.getAmount());
    }

    public static void assertMapperListEntity(ListEntity listEntity, ListDto listDto ) {
        Assertions.assertEquals(listEntity.getId(), listDto.getId());
        Assertions.assertEquals(listEntity.getIdUser(), listDto.getIdUser());
        Assertions.assertEquals(listEntity.getDescription(), listDto.getDescription());
        Assertions.assertEquals(listEntity.getDate(), listDto.getDate());
        Assertions.assertEquals(listEntity.getPeriodTypeEntity().name(), listDto.getPeriodTypeDto().name());
        Assertions.assertEquals(listEntity.getPeriod(), listDto.getPeriod());
        Assertions.assertEquals(listEntity.getAmount(), listDto.getAmount());
    }

    public static void assertMapperListEquals(ListDto listDtoA, ListDto listDtoB) {
        Assertions.assertEquals(listDtoA.getId(), listDtoB.getId());
        Assertions.assertEquals(listDtoA.getIdUser(), listDtoB.getIdUser());
        Assertions.assertEquals(listDtoA.getDescription(), listDtoB.getDescription());
        Assertions.assertEquals(listDtoA.getDate(), listDtoB.getDate());
        Assertions.assertEquals(listDtoA.getPeriodTypeDto().name(), listDtoB.getPeriodTypeDto().name());
        Assertions.assertEquals(listDtoA.getPeriod(), listDtoB.getPeriod());
        Assertions.assertEquals(listDtoA.getAmount(), listDtoB.getAmount());
    }
}
