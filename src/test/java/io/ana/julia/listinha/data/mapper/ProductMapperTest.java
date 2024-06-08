package io.ana.julia.listinha.data.mapper;

import io.ana.julia.listinha.data.dto.ItemDto;
import io.ana.julia.listinha.data.entity.ItemEntity;
import io.ana.julia.listinha.utils.AssertionItemData;
import io.ana.julia.listinha.utils.DataFactoryItem;
import org.junit.jupiter.api.Test;

public class ItemMapperTest {

    private final ItemMapper itemMapper = new ItemMapper();

    @Test
    public void givenItemDTO_whenMapper_thenValueIsEqual() {
        ItemDto itemDto = DataFactoryItem.itemDto();
        ItemEntity itemEntity = itemMapper.toItemEntity(itemDto);
        AssertionItemData.assertMapperItemDTO(itemDto, itemEntity);
    }

    @Test
    public void givenItemEntity_whenMapper_thenValueIsEqual() {
        ItemEntity itemEntity = DataFactoryItem.itemEntity();
        ItemDto itemDto = itemMapper.toItemDTO(itemEntity);
        AssertionItemData.assertMapperItemEntity(itemEntity, itemDto);
    }
}
