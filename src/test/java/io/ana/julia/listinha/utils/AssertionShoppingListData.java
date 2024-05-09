package io.ana.julia.listinha.utils;

import io.ana.julia.listinha.data.dto.ShoppingListDto;
import io.ana.julia.listinha.data.entity.ShoppingListEntity;
import org.junit.jupiter.api.Assertions;

public class AssertionShoppingListData {

    public static void assertMapperListDTO(ShoppingListDto shoppingListDto, ShoppingListEntity shoppingListEntity) {
        Assertions.assertEquals(shoppingListDto.getId(), shoppingListEntity.getId());
        Assertions.assertEquals(shoppingListDto.getUserId(), shoppingListEntity.getUser().getId());
        Assertions.assertEquals(shoppingListDto.getDescription(), shoppingListEntity.getDescription());
        Assertions.assertEquals(shoppingListDto.getDate(), shoppingListEntity.getDate());
        Assertions.assertEquals(shoppingListDto.getPeriodTypeDto().name(), shoppingListEntity.getPeriodTypeEntity().name());
        Assertions.assertEquals(shoppingListDto.getPeriod(), shoppingListEntity.getPeriod());
        Assertions.assertEquals(shoppingListDto.getAmount(), shoppingListEntity.getAmount());
    }

    public static void assertMapperListEntity(ShoppingListEntity shoppingListEntity, ShoppingListDto shoppingListDto) {
        Assertions.assertEquals(shoppingListEntity.getId(), shoppingListDto.getId());
        Assertions.assertEquals(shoppingListEntity.getUser().getId(), shoppingListDto.getUserId());
        Assertions.assertEquals(shoppingListEntity.getDescription(), shoppingListDto.getDescription());
        Assertions.assertEquals(shoppingListEntity.getDate(), shoppingListDto.getDate());
        Assertions.assertEquals(shoppingListEntity.getPeriodTypeEntity().name(), shoppingListDto.getPeriodTypeDto().name());
        Assertions.assertEquals(shoppingListEntity.getPeriod(), shoppingListDto.getPeriod());
        Assertions.assertEquals(shoppingListEntity.getAmount(), shoppingListDto.getAmount());
    }

    public static void assertMapperListEquals(ShoppingListDto shoppingListDtoA, ShoppingListDto shoppingListDtoB) {
        Assertions.assertEquals(shoppingListDtoA.getId(), shoppingListDtoB.getId());
        Assertions.assertEquals(shoppingListDtoA.getUserId(), shoppingListDtoB.getUserId());
        Assertions.assertEquals(shoppingListDtoA.getDescription(), shoppingListDtoB.getDescription());
        Assertions.assertEquals(shoppingListDtoA.getDate(), shoppingListDtoB.getDate());
        Assertions.assertEquals(shoppingListDtoA.getPeriodTypeDto().name(), shoppingListDtoB.getPeriodTypeDto().name());
        Assertions.assertEquals(shoppingListDtoA.getPeriod(), shoppingListDtoB.getPeriod());
        Assertions.assertEquals(shoppingListDtoA.getAmount(), shoppingListDtoB.getAmount());
    }
}
