package io.ana.julia.listinha.service;

import io.ana.julia.listinha.data.dto.ShoppingListDto;
import io.ana.julia.listinha.usecase.shoppinglist.CreateShoppingListUseCase;
import io.ana.julia.listinha.usecase.shoppinglist.DeleteShoppingListUseCase;
import io.ana.julia.listinha.usecase.shoppinglist.FindAllShoppingListUseCase;
import io.ana.julia.listinha.usecase.shoppinglist.UpdateShoppingListUseCase;
import io.ana.julia.listinha.utils.AssertionShoppingListData;
import io.ana.julia.listinha.utils.DataFactoryShoppingList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ShoppingListServiceTest {

    private static CreateShoppingListUseCase createShoppingListUseCase;
    private DeleteShoppingListUseCase deleteShoppingListUseCase;
    private UpdateShoppingListUseCase updateShoppingListUseCase;
    private FindAllShoppingListUseCase findAllShoppingListUseCase;
    private ShoppingShoppingListServiceImpl listService;

    @BeforeEach
    void setup() {
        createShoppingListUseCase = Mockito.mock(CreateShoppingListUseCase.class);
        deleteShoppingListUseCase = Mockito.mock(DeleteShoppingListUseCase.class);
        updateShoppingListUseCase = Mockito.mock(UpdateShoppingListUseCase.class);
        findAllShoppingListUseCase = Mockito.mock(FindAllShoppingListUseCase.class);
        listService = new ShoppingShoppingListServiceImpl(
                createShoppingListUseCase,
                deleteShoppingListUseCase,
                updateShoppingListUseCase,
                findAllShoppingListUseCase);
    }

    @Test
    public void givenListDto_whenCreateList_thenReturnValidCreateList() {
        when(createShoppingListUseCase.execute(any())).thenReturn(DataFactoryShoppingList.listDto());
        ShoppingListDto shoppingListDto = listService.createList(DataFactoryShoppingList.listDto());
        AssertionShoppingListData.assertMapperListEquals(shoppingListDto, DataFactoryShoppingList.listDto());

        verify(createShoppingListUseCase).execute(any());
    }
    @Test
    public void givenListId_whenDeleteLis_thenReturnValidDeleteList() {
        doNothing().when(deleteShoppingListUseCase).execute(any());

        listService.deleteList(DataFactoryShoppingList.listDto().getId());

        verify(deleteShoppingListUseCase).execute(any());
    }

    @Test
    public void givenListDto_whenUpdateList_thenReturnValidUpdateList() {
        when(updateShoppingListUseCase.execute(any())).thenReturn(DataFactoryShoppingList.listDto());
        ShoppingListDto shoppingListDto = listService.updateList(DataFactoryShoppingList.listDto());
        AssertionShoppingListData.assertMapperListEquals(shoppingListDto, DataFactoryShoppingList.listDto());

        verify(updateShoppingListUseCase).execute(any());
    }

    @Test
    public void givenNoAttributes_whenFindAllList_thenReturnValidListLists() {
        when(findAllShoppingListUseCase.execute()).thenReturn(
                List.of(DataFactoryShoppingList.listDto(),
                        DataFactoryShoppingList.listDto()));

        List<ShoppingListDto> dtoList = listService.findAllLists();
        AssertionShoppingListData.assertMapperListEquals(dtoList.get(1), DataFactoryShoppingList.listDto());

        verify(findAllShoppingListUseCase).execute();
    }
}
