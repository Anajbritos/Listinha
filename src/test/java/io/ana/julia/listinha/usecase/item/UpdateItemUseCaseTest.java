package io.ana.julia.listinha.usecase.item;

import io.ana.julia.listinha.data.ItemRepository;
import io.ana.julia.listinha.data.dto.ItemDto;
import io.ana.julia.listinha.data.dto.UserDto;
import io.ana.julia.listinha.data.mapper.ItemMapper;
import io.ana.julia.listinha.exception.IdNotExistsException;
import io.ana.julia.listinha.utils.AssertionItemData;
import io.ana.julia.listinha.utils.AssertionUserData;
import io.ana.julia.listinha.utils.DataFactoryItem;
import io.ana.julia.listinha.utils.DataFactoryUser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UpdateItemUseCaseTest {

    private static ItemRepository itemRepository;
    private static ItemMapper itemMapper;
    private static UpdateItemUseCaseImpl updateItemUseCase;

    @BeforeEach
    void setup() {
        itemRepository = Mockito.mock(ItemRepository.class);
        itemMapper = Mockito.mock(ItemMapper.class);
        updateItemUseCase = new UpdateItemUseCaseImpl(itemRepository,itemMapper);
    }

    @Test
    public void givenItemDto_WhenExecute_ThenUpdateItemWithSuccess() {
        when(itemRepository.existsById(any())).thenReturn(true);
        when(itemMapper.toItemEntity(any())).thenReturn(DataFactoryItem.itemEntity());
        when(itemRepository.save(any())).thenReturn(DataFactoryItem.itemEntity());
        when(itemMapper.toItemDTO(any())).thenReturn(DataFactoryItem.itemDto());

        ItemDto itemDto = updateItemUseCase.execute(DataFactoryItem.itemDto());
        AssertionItemData.assertMapperItemDTO(itemDto, DataFactoryItem.itemEntity());

        verify(itemRepository).existsById(any());
        verify(itemMapper).toItemEntity(any());
        verify(itemRepository).save(any());
        verify(itemMapper).toItemDTO(any());
    }

    @Test
    public void givenItemDto_WhenExecute_ThenUpdateItemWithFailure() {
        when(itemRepository.existsById(any())).thenReturn(false);

        Assertions.assertThrows(IdNotExistsException.class,
                ()-> updateItemUseCase.execute(DataFactoryItem.itemDto()));

        verify(itemRepository).existsById(any());
    }
}
