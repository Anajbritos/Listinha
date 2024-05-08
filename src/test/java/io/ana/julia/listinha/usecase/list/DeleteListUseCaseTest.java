package io.ana.julia.listinha.usecase.list;

import io.ana.julia.listinha.data.ListRepository;
import io.ana.julia.listinha.data.mapper.ListMapper;
import io.ana.julia.listinha.exception.IdNotExistsException;
import io.ana.julia.listinha.utils.DataFactoryList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class DeleteListUseCaseTest {
    private ListRepository listRepository;
    private ListMapper listMapper;
    private DeleteListUseCaseImpl deleteListUseCase;

    @BeforeEach
    void setup() {
        listRepository = Mockito.mock(ListRepository.class);
        listMapper = Mockito.mock(ListMapper.class);
        deleteListUseCase = new DeleteListUseCaseImpl(listRepository,listMapper);
    }

    @Test
    public void givenIdList_whenExecute_thenDeleteListWithSuccess() {
        when(listRepository.findById(anyLong())).thenReturn(Optional.of(DataFactoryList.listEntity()));
        doNothing().when(listRepository).deleteById(anyLong());
        deleteListUseCase.execute(DataFactoryList.listEntity().getId());

        verify(listRepository).findById(anyLong());
        verify(listRepository).deleteById(anyLong());
    }

    @Test
    public void givenIdList_whenExecute_thenDeleteListWithFailure() {
        when(listRepository.findById(anyLong())).thenReturn(Optional.empty());

        Assertions.assertThrows(IdNotExistsException.class,
                ()-> deleteListUseCase.execute(DataFactoryList.listEntity().getId()));

        verify(listRepository).findById(anyLong());
    }
}
