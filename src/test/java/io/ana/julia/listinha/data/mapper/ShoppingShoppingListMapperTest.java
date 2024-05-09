package io.ana.julia.listinha.data.mapper;

import io.ana.julia.listinha.data.dto.ShoppingListDto;
import io.ana.julia.listinha.data.entity.ShoppingListEntity;
import io.ana.julia.listinha.data.entity.UserEntity;
import io.ana.julia.listinha.utils.AssertionShoppingListData;
import io.ana.julia.listinha.utils.DataFactoryShoppingList;
import org.junit.jupiter.api.Test;

public class ShoppingShoppingListMapperTest {

    private final ShoppingListMapper shoppingListMapper = new ShoppingListMapper();
    private final UserEntity userEntity = new UserEntity();

    @Test
    public void givenListDTO_whenMapper_thenValueIsEqual() {
        ShoppingListDto shoppingListDto = DataFactoryShoppingList.listDto();
        ShoppingListEntity shoppingListEntity = shoppingListMapper.toListEntity(
                shoppingListDto,
                DataFactoryShoppingList.listEntity().getUser());
        AssertionShoppingListData.assertMapperListDTO(shoppingListDto, shoppingListEntity);
    }

    @Test
    public void givenListEntity_whenMapper_thenValueIsEqual() {
        ShoppingListEntity shoppingListEntity = DataFactoryShoppingList.listEntity();
        ShoppingListDto shoppingListDto = shoppingListMapper.toListDTO(shoppingListEntity);
        AssertionShoppingListData.assertMapperListEntity(shoppingListEntity, shoppingListDto);
    }
}
