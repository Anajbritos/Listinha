package io.ana.julia.listinha.usecase.shoppinglist;

import io.ana.julia.listinha.data.ShoppingListRepository;
import io.ana.julia.listinha.data.dto.ShoppingListDto;
import io.ana.julia.listinha.data.mapper.ShoppingListMapper;
import io.ana.julia.listinha.utils.AssertionShoppingListData;
import io.ana.julia.listinha.utils.DataFactoryShoppingList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class FindAllShoppingListUseCaseTest {

    private ShoppingListRepository shoppingListRepository;
    private ShoppingListMapper shoppingListMapper;
    private FindAllShoppingListUseCaseImpl findAllListUseCase;

    @BeforeEach
    void setup() {
        shoppingListRepository = Mockito.mock(ShoppingListRepository.class);
        shoppingListMapper = Mockito.mock(ShoppingListMapper.class);
        findAllListUseCase = new FindAllShoppingListUseCaseImpl(shoppingListRepository, shoppingListMapper);
    }

    @Test
    public void givenNotAttribute_whenExecute_thenFindAllListWithSuccess() {
        when(shoppingListRepository.findAll()).thenReturn(
                List.of(
                        DataFactoryShoppingList.listEntity(),
                        DataFactoryShoppingList.listEntity(),
                        DataFactoryShoppingList.listEntity()));
        when(shoppingListMapper.toListDTO(any())).thenReturn(DataFactoryShoppingList.listDto());

        List<ShoppingListDto> dtoList = findAllListUseCase.execute();
        Assertions.assertNotNull(dtoList);
        Assertions.assertEquals(dtoList.size(),3);
        AssertionShoppingListData.assertMapperListEquals(DataFactoryShoppingList.listDto(),dtoList.get(2));

        verify(shoppingListRepository).findAll();
        verify(shoppingListMapper,times(3)).toListDTO(any());
    }

    @Test
    public void givenNotAttribute_whenExecute_thenFindAllListWithFailure() {
        when(shoppingListRepository.findAll()).thenReturn(List.of());

        List<ShoppingListDto> dtoList = findAllListUseCase.execute();
        Assertions.assertEquals(dtoList.size(),0);

        verify(shoppingListRepository).findAll();
        verify(shoppingListMapper, never()).toListDTO(any());
    }
}
