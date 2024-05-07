package io.ana.julia.listinha.utils;

import io.ana.julia.listinha.data.dto.ItemDto;
import io.ana.julia.listinha.data.entity.ItemEntity;
import org.junit.jupiter.api.Assertions;

public class AssertionItemData {

    public static void assertMapperItemDTO(ItemDto itemDto, ItemEntity itemEntity) {
        Assertions.assertEquals(itemDto.getId(), itemEntity.getId());
        Assertions.assertEquals(itemDto.getDescription(), itemEntity.getDescription());
        Assertions.assertEquals(itemDto.getTypeItemDto().name(), itemEntity.getTypeItemEntity().name());
        Assertions.assertEquals(itemDto.getItemMeasurementDto().name(), itemEntity.getItemMeasurementEntity().name());
        Assertions.assertEquals(itemDto.getPrice(), itemEntity.getPrice());
    }

    public static void assertMapperItemEntity(ItemEntity itemEntity, ItemDto itemDto ) {
        Assertions.assertEquals(itemEntity.getId(), itemDto.getId());
        Assertions.assertEquals(itemEntity.getDescription(), itemDto.getDescription());
        Assertions.assertEquals(itemEntity.getTypeItemEntity().name(), itemDto.getTypeItemDto().name());
        Assertions.assertEquals(itemEntity.getItemMeasurementEntity().name(), itemDto.getItemMeasurementDto().name());
        Assertions.assertEquals(itemEntity.getPrice(), itemEntity.getPrice());
    }
}
