package io.ana.julia.listinha.controller;

import io.ana.julia.listinha.data.dto.ListDto;
import io.ana.julia.listinha.service.ListService;
import io.ana.julia.listinha.utils.AssertionListData;
import io.ana.julia.listinha.utils.DataFactoryList;
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
public class ListControllerTest {

    private ListService listService;
    private ListController listController;

    @BeforeEach
    void setup() {
        listService = Mockito.mock(ListService.class);
        listController = new ListController(listService);
    }

    @Test
    public void givenResponseListDto_whenCreateItem_thenReturnResponseCreated() {
        when(listService.createList(any())).thenReturn(DataFactoryList.listDto());
        ResponseEntity<ListDto> responseCreatedList = listController.createList(DataFactoryList.listDto());

        Assertions.assertNotNull(responseCreatedList);
        Assertions.assertNotNull(responseCreatedList.getBody());
        Assertions.assertEquals(responseCreatedList.getStatusCode(), HttpStatus.CREATED);
        AssertionListData.assertMapperListEquals(responseCreatedList.getBody(), DataFactoryList.listDto());
        Assertions.assertEquals(responseCreatedList.getBody().getClass(), DataFactoryList.listDto().getClass());

        verify(listService).createList(any());
    }

    @Test
    public void givenResponseVoid_whenDeleteList_thenReturnResponseDeleted() {
        doNothing().when(listService).deleteList(any());
        ResponseEntity<Void> responseDeletedList = listController.deleteList(DataFactoryList.listDto().getId());

        Assertions.assertNotNull(responseDeletedList);
        Assertions.assertNull(responseDeletedList.getBody());
        Assertions.assertEquals(responseDeletedList.getStatusCode(), HttpStatus.NO_CONTENT);

        verify(listService).deleteList(any());
    }

    @Test
    public void givenResponseListDto_whenUpdateList_thenReturnResponseUpdated() {
        when(listService.updateList(any())).thenReturn(DataFactoryList.listDto());
        ResponseEntity<ListDto> responseUpdatedList = listController.updateList(DataFactoryList.listDto());

        Assertions.assertNotNull(responseUpdatedList);
        Assertions.assertNotNull(responseUpdatedList.getBody());
        Assertions.assertEquals(responseUpdatedList.getStatusCode(), HttpStatus.OK);
        AssertionListData.assertMapperListEquals(responseUpdatedList.getBody(), DataFactoryList.listDto());
        Assertions.assertEquals(responseUpdatedList.getBody().getClass(), DataFactoryList.listDto().getClass());

        verify(listService).updateList(any());
    }

    @Test
    public void givenNotAttributes_whenFindAllItems_thenReturnResponseFindAll() {
        when(listService.findAllLists()).thenReturn(
                List.of(DataFactoryList.listDto(),
                        DataFactoryList.listDto(),
                        DataFactoryList.listDto()));

        ResponseEntity<List<ListDto>> responseFindAllList = listController.findAllList();

        Assertions.assertNotNull(responseFindAllList);
        Assertions.assertNotNull(responseFindAllList.getBody());
        Assertions.assertEquals(responseFindAllList.getStatusCode(), HttpStatus.OK);
        Assertions.assertEquals(responseFindAllList.getBody().size(), 3);
        AssertionListData.assertMapperListEquals(responseFindAllList.getBody().get(2), DataFactoryList.listDto());
        Assertions.assertEquals(responseFindAllList.getBody().get(2).getClass(), DataFactoryList.listDto().getClass());

        verify(listService).findAllLists();
    }
}
