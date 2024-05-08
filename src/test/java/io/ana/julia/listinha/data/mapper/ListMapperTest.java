package io.ana.julia.listinha.data.mapper;

import io.ana.julia.listinha.data.dto.ListDto;
import io.ana.julia.listinha.data.entity.ListEntity;
import io.ana.julia.listinha.utils.AssertionListData;
import io.ana.julia.listinha.utils.DataFactoryList;
import org.junit.jupiter.api.Test;

public class ListMapperTest {

    private final ListMapper listMapper = new ListMapper();

    @Test
    public void givenListDTO_whenMapper_thenValueIsEqual() {
        ListDto listDto = DataFactoryList.listDto();
        ListEntity listEntity = listMapper.toListEntity(listDto);
        AssertionListData.assertMapperListDTO(listDto, listEntity);
    }

    @Test
    public void givenListEntity_whenMapper_thenValueIsEqual() {
        ListEntity listEntity = DataFactoryList.listEntity();
        ListDto listDto = listMapper.toListDTO(listEntity);
        AssertionListData.assertMapperListEntity(listEntity, listDto);
    }
}
