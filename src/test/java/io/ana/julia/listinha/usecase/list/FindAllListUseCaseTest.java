package io.ana.julia.listinha.usecase.list;

import io.ana.julia.listinha.data.ListRepository;
import io.ana.julia.listinha.data.dto.ListDto;
import io.ana.julia.listinha.data.mapper.ListMapper;
import io.ana.julia.listinha.utils.AssertionListData;
import io.ana.julia.listinha.utils.DataFactoryList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class FindAllListUseCaseTest {

    private ListRepository listRepository;
    private ListMapper listMapper;
    private FindAllListUseCaseImpl findAllListUseCase;

    @BeforeEach
    void setup() {
        listRepository = Mockito.mock(ListRepository.class);
        listMapper = Mockito.mock(ListMapper.class);
        findAllListUseCase = new FindAllListUseCaseImpl(listRepository, listMapper);
    }

    @Test
    public void givenNotAttribute_whenExecute_thenFindAllListWithSuccess() {
        when(listRepository.findAll()).thenReturn(
                List.of(
                        DataFactoryList.listEntity(),
                        DataFactoryList.listEntity(),
                        DataFactoryList.listEntity()));
        when(listMapper.toListDTO(any())).thenReturn(DataFactoryList.listDto());

        List<ListDto> dtoList = findAllListUseCase.execute();
        Assertions.assertNotNull(dtoList);
        Assertions.assertEquals(dtoList.size(),3);
        AssertionListData.assertMapperListEquals(DataFactoryList.listDto(),dtoList.get(2));

        verify(listRepository).findAll();
        verify(listMapper,times(3)).toListDTO(any());
    }

    @Test
    public void givenNotAttribute_whenExecute_thenFindAllListWithFailure() {
        when(listRepository.findAll()).thenReturn(List.of());

        List<ListDto> dtoList = findAllListUseCase.execute();
        Assertions.assertEquals(dtoList.size(),0);

        verify(listRepository).findAll();
        verify(listMapper, never()).toListDTO(any());
    }
}
