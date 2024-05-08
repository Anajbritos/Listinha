package io.ana.julia.listinha.controller;

import io.ana.julia.listinha.data.dto.ItemDto;
import io.ana.julia.listinha.service.ItemService;
import io.ana.julia.listinha.service.UserServiceImpl;
import io.ana.julia.listinha.utils.AssertionItemData;
import io.ana.julia.listinha.utils.DataFactoryItem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class ItemControllerTest {

    private ItemService itemService;
    private ItemController itemController;

    @BeforeEach
    void setup() {
        itemService = Mockito.mock(ItemService.class);
        itemController = new ItemController(itemService);
    }

    @Test
    public void givenResponseItemDto_whenCreateItem_thenReturnResponseCreated() {
        when(itemService.createItem(any())).thenReturn(DataFactoryItem.itemDto());
        ResponseEntity<ItemDto> responseCreatedItem = itemController.createItem(DataFactoryItem.itemDto());

        Assertions.assertNotNull(responseCreatedItem);
        Assertions.assertNotNull(responseCreatedItem.getBody());
        Assertions.assertEquals(responseCreatedItem.getStatusCode(), HttpStatus.CREATED);
        AssertionItemData.assertMapperItemEquals(responseCreatedItem.getBody(), DataFactoryItem.itemDto());
        Assertions.assertEquals(responseCreatedItem.getBody().getClass(), DataFactoryItem.itemDto().getClass());

        verify(itemService).createItem(any());
    }

    @Test
    public void givenResponseVoid_whenDeleteItem_thenReturnResponseDeleted() {
        doNothing().when(itemService).deleteItem(any());
        ResponseEntity<Void> responseDeletedItem = itemController.deleteItem(DataFactoryItem.itemDto().getId());

        Assertions.assertNotNull(responseDeletedItem);
        Assertions.assertNull(responseDeletedItem.getBody());
        Assertions.assertEquals(responseDeletedItem.getStatusCode(), HttpStatus.NO_CONTENT);

        verify(itemService).deleteItem(any());
    }

    @Test
    public void givenResponseItemDto_whenUpdateItem_thenReturnResponseUpdated() {
        when(itemService.updateItem(any())).thenReturn(DataFactoryItem.itemDto());
        ResponseEntity<ItemDto> responseUpdatedItem = itemController.updateItem(DataFactoryItem.itemDto());

        Assertions.assertNotNull(responseUpdatedItem);
        Assertions.assertNotNull(responseUpdatedItem.getBody());
        Assertions.assertEquals(responseUpdatedItem.getStatusCode(), HttpStatus.OK);
        AssertionItemData.assertMapperItemEquals(responseUpdatedItem.getBody(), DataFactoryItem.itemDto());
        Assertions.assertEquals(responseUpdatedItem.getBody().getClass(), DataFactoryItem.itemDto().getClass());

        verify(itemService).updateItem(any());
    }

    @Test
    public void givenNotAttributes_whenFindAllItems_thenReturnResponseFindAll() {
        when(itemService.findAllItems()).thenReturn(
                List.of(DataFactoryItem.itemDto(), DataFactoryItem.itemDto(), DataFactoryItem.itemDto()));

        ResponseEntity<List<ItemDto>> responseFindAllItem = itemController.findAllItems();

        Assertions.assertNotNull(responseFindAllItem);
        Assertions.assertNotNull(responseFindAllItem.getBody());
        Assertions.assertEquals(responseFindAllItem.getStatusCode(), HttpStatus.OK);
        Assertions.assertEquals(responseFindAllItem.getBody().size(), 3);
        AssertionItemData.assertMapperItemEquals(responseFindAllItem.getBody().get(2), DataFactoryItem.itemDto());
        Assertions.assertEquals(responseFindAllItem.getBody().get(2).getClass(), DataFactoryItem.itemDto().getClass());

        verify(itemService).findAllItems();
    }
}
