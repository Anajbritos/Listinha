package io.ana.julia.listinha.controller;

import io.ana.julia.listinha.data.dto.ShoppingListDto;
import io.ana.julia.listinha.service.ShoppingListService;
import io.ana.julia.listinha.utils.AssertionShoppingListData;
import io.ana.julia.listinha.utils.DataFactoryShoppingList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class ShoppingListControllerTest {

    private ShoppingListService shoppingListService;
    private ShoppingListController shoppingListController;

    @BeforeEach
    void setup() {
        shoppingListService = Mockito.mock(ShoppingListService.class);
        shoppingListController = new ShoppingListController(shoppingListService);
    }

    @Test
    public void givenResponseListDto_whenCreateItem_thenReturnResponseCreated() {
        when(shoppingListService.createList(any())).thenReturn(DataFactoryShoppingList.listDto());
        ResponseEntity<ShoppingListDto> responseCreatedList = shoppingListController.createList(DataFactoryShoppingList.listDto());

        Assertions.assertNotNull(responseCreatedList);
        Assertions.assertNotNull(responseCreatedList.getBody());
        Assertions.assertEquals(responseCreatedList.getStatusCode(), HttpStatus.CREATED);
        AssertionShoppingListData.assertMapperListEquals(responseCreatedList.getBody(), DataFactoryShoppingList.listDto());
        Assertions.assertEquals(responseCreatedList.getBody().getClass(), DataFactoryShoppingList.listDto().getClass());

        verify(shoppingListService).createList(any());
    }

    @Test
    public void givenResponseVoid_whenDeleteList_thenReturnResponseDeleted() {
        doNothing().when(shoppingListService).deleteList(any());
        ResponseEntity<Void> responseDeletedList = shoppingListController.deleteList(DataFactoryShoppingList.listDto().getId());

        Assertions.assertNotNull(responseDeletedList);
        Assertions.assertNull(responseDeletedList.getBody());
        Assertions.assertEquals(responseDeletedList.getStatusCode(), HttpStatus.NO_CONTENT);

        verify(shoppingListService).deleteList(any());
    }

    @Test
    public void givenResponseListDto_whenUpdateList_thenReturnResponseUpdated() {
        when(shoppingListService.updateList(any())).thenReturn(DataFactoryShoppingList.listDto());
        ResponseEntity<ShoppingListDto> responseUpdatedList = shoppingListController.updateList(DataFactoryShoppingList.listDto());

        Assertions.assertNotNull(responseUpdatedList);
        Assertions.assertNotNull(responseUpdatedList.getBody());
        Assertions.assertEquals(responseUpdatedList.getStatusCode(), HttpStatus.OK);
        AssertionShoppingListData.assertMapperListEquals(responseUpdatedList.getBody(), DataFactoryShoppingList.listDto());
        Assertions.assertEquals(responseUpdatedList.getBody().getClass(), DataFactoryShoppingList.listDto().getClass());

        verify(shoppingListService).updateList(any());
    }

    @Test
    public void givenNotAttributes_whenFindAllItems_thenReturnResponseFindAll() {
        when(shoppingListService.findAllLists()).thenReturn(
                List.of(DataFactoryShoppingList.listDto(),
                        DataFactoryShoppingList.listDto(),
                        DataFactoryShoppingList.listDto()));

        ResponseEntity<List<ShoppingListDto>> responseFindAllList = shoppingListController.findAllList();

        Assertions.assertNotNull(responseFindAllList);
        Assertions.assertNotNull(responseFindAllList.getBody());
        Assertions.assertEquals(responseFindAllList.getStatusCode(), HttpStatus.OK);
        Assertions.assertEquals(responseFindAllList.getBody().size(), 3);
        AssertionShoppingListData.assertMapperListEquals(responseFindAllList.getBody().get(2), DataFactoryShoppingList.listDto());
        Assertions.assertEquals(responseFindAllList.getBody().get(2).getClass(), DataFactoryShoppingList.listDto().getClass());

        verify(shoppingListService).findAllLists();
    }
}
