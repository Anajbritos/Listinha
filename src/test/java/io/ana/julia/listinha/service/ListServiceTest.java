package io.ana.julia.listinha.service;

import io.ana.julia.listinha.data.dto.ListDto;
import io.ana.julia.listinha.usecase.list.CreateListUseCase;
import io.ana.julia.listinha.usecase.list.DeleteListUseCase;
import io.ana.julia.listinha.usecase.list.FindAllListUseCase;
import io.ana.julia.listinha.usecase.list.UpdateListUseCase;
import io.ana.julia.listinha.utils.AssertionListData;
import io.ana.julia.listinha.utils.DataFactoryItem;
import io.ana.julia.listinha.utils.DataFactoryList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class ListServiceTest {

    private static CreateListUseCase createListUseCase;
    private DeleteListUseCase deleteListUseCase;
    private UpdateListUseCase updateListUseCase;
    private FindAllListUseCase findAllListUseCase;
    private ListServiceImpl listService;

    @BeforeEach
    void setup() {
        createListUseCase = Mockito.mock(CreateListUseCase.class);
        deleteListUseCase = Mockito.mock(DeleteListUseCase.class);
        updateListUseCase = Mockito.mock(UpdateListUseCase.class);
        findAllListUseCase = Mockito.mock(FindAllListUseCase.class);
        listService = new ListServiceImpl(
                createListUseCase,
                deleteListUseCase,
                updateListUseCase,
                findAllListUseCase);
    }

    @Test
    public void givenListDto_whenCreateList_thenReturnValidCreateList() {
        when(createListUseCase.execute(any())).thenReturn(DataFactoryList.listDto());
        ListDto listDto = listService.createList(DataFactoryList.listDto());
        AssertionListData.assertMapperListEquals(listDto,DataFactoryList.listDto());

        verify(createListUseCase).execute(any());
    }
    @Test
    public void givenListId_whenDeleteLis_thenReturnValidDeleteList() {
        doNothing().when(deleteListUseCase).execute(any());

        listService.deleteList(DataFactoryList.listDto().getId());

        verify(deleteListUseCase).execute(any());
    }

    @Test
    public void givenListDto_whenUpdateList_thenReturnValidUpdateList() {
        when(updateListUseCase.execute(any())).thenReturn(DataFactoryList.listDto());
        ListDto listDto = listService.updateList(DataFactoryList.listDto());
        AssertionListData.assertMapperListEquals(listDto,DataFactoryList.listDto());

        verify(updateListUseCase).execute(any());
    }

    @Test
    public void givenNoAttributes_whenFindAllList_thenReturnValidListLists() {
        when(findAllListUseCase.execute()).thenReturn(
                List.of(DataFactoryList.listDto(),
                        DataFactoryList.listDto()));

        List<ListDto> dtoList = listService.findAllLists();
        AssertionListData.assertMapperListEquals(dtoList.get(1),DataFactoryList.listDto());

        verify(findAllListUseCase).execute();
    }
}
