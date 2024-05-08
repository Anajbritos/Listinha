package io.ana.julia.listinha.service;

import io.ana.julia.listinha.data.dto.ItemDto;
import io.ana.julia.listinha.usecase.item.CreateItemUseCase;
import io.ana.julia.listinha.usecase.item.DeleteItemUseCase;
import io.ana.julia.listinha.usecase.item.FindAllItensUseCase;
import io.ana.julia.listinha.usecase.item.UpdateItemUseCase;
import io.ana.julia.listinha.usecase.user.CreateUserUseCase;
import io.ana.julia.listinha.usecase.user.DeleteUserUseCase;
import io.ana.julia.listinha.usecase.user.FindAllUsersUseCase;
import io.ana.julia.listinha.usecase.user.UpdateUserUseCase;
import io.ana.julia.listinha.utils.AssertionItemData;
import io.ana.julia.listinha.utils.DataFactoryItem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class ItemServiceTest {

    private static CreateItemUseCase createItemUseCase;
    private DeleteItemUseCase deleteItemUseCase;
    private UpdateItemUseCase updateItemUseCase;
    private FindAllItensUseCase findAllItensUseCase;
    private ItemServiceImpl itemService;

    @BeforeEach
    void setup() {
        createItemUseCase = Mockito.mock(CreateItemUseCase.class);
        deleteItemUseCase = Mockito.mock(DeleteItemUseCase.class);
        updateItemUseCase = Mockito.mock(UpdateItemUseCase.class);
        findAllItensUseCase = Mockito.mock(FindAllItensUseCase.class);
        itemService = new ItemServiceImpl(
                createItemUseCase,
                deleteItemUseCase,
                updateItemUseCase,
                findAllItensUseCase);
    }

    @Test
    public void givenItemDto_whenCreateItem_thenReturnValidCreateItem() {
        when(createItemUseCase.execute(any())).thenReturn(DataFactoryItem.itemDto());

        ItemDto itemDto = itemService.createItem(DataFactoryItem.itemDto());
        AssertionItemData.assertMapperItemEquals(itemDto, DataFactoryItem.itemDto());

        verify(createItemUseCase).execute(any());
    }

    @Test
    public void givenItemId_whenDeleteItem_thenReturnValidDeleteItem() {
        doNothing().when(deleteItemUseCase).execute(any());

        itemService.deleteItem(DataFactoryItem.itemDto().getId());

        verify(deleteItemUseCase).execute(any());
    }

    @Test
    public void givenItemDto_whenUpdateItem_thenReturnValidUpdateItem() {
        when(updateItemUseCase.execute(any())).thenReturn(DataFactoryItem.itemDto());

        ItemDto itemDto = itemService.updateItem(DataFactoryItem.itemDto());
        AssertionItemData.assertMapperItemEquals(itemDto, DataFactoryItem.itemDto());

        verify(updateItemUseCase).execute(any());
    }

    @Test
    public void givenNotAttributes_whenFindAllItems_thenReturnValidFindAllItems() {
        when(findAllItensUseCase.execute()).thenReturn(
                List.of(
                DataFactoryItem.itemDto(),
                DataFactoryItem.itemDto()));

        List<ItemDto> itemDto = itemService.findAllItems();
        AssertionItemData.assertMapperItemEquals(itemDto.get(0), DataFactoryItem.itemDto());
        Assertions.assertNotNull(itemDto);

        verify(findAllItensUseCase).execute();
    }
}
