package io.ana.julia.listinha.usecase.item;

import io.ana.julia.listinha.data.ItemRepository;
import io.ana.julia.listinha.data.mapper.ItemMapper;
import io.ana.julia.listinha.exception.IdNotExistsException;
import io.ana.julia.listinha.utils.DataFactoryItem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class DeleteItemUseCaseTest {

    private static ItemRepository itemRepository;
    private static ItemMapper itemMapper;
    private static DeleteItemUseCaseImpl deleteItemUseCase;

    @BeforeEach
    void setup() {
        itemRepository = Mockito.mock(ItemRepository.class);
        itemMapper = Mockito.mock(ItemMapper.class);
        deleteItemUseCase = new DeleteItemUseCaseImpl(itemRepository,itemMapper);
    }

    @Test
    public void givenItemDto_whenExecute_thenDeleteItemWithSuccess() {
        when(itemRepository.findById(any())).thenReturn(Optional.of(DataFactoryItem.itemEntity()));
        when(itemMapper.toItemEntity(any())).thenReturn(DataFactoryItem.itemEntity());
        doNothing().when(itemRepository).deleteById(DataFactoryItem.itemEntity().getId());
        deleteItemUseCase.execute(DataFactoryItem.itemDto());

        verify(itemRepository).findById(any());
        verify(itemMapper).toItemEntity(any());
        verify(itemRepository).deleteById(any());
    }

    @Test
    public void givenItemDto_whenExecute_thenDeleteItemWithFailure() {
        when(itemRepository.findById(any())).thenReturn(Optional.empty());

        Assertions.assertThrows(IdNotExistsException.class,
                ()-> deleteItemUseCase.execute(DataFactoryItem.itemDto()));

        verify(itemRepository).findById(any());
    }
}
