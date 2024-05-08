package io.ana.julia.listinha.usecase.item;

import io.ana.julia.listinha.data.ItemRepository;
import io.ana.julia.listinha.data.UserRepository;
import io.ana.julia.listinha.data.dto.ItemDto;
import io.ana.julia.listinha.data.dto.UserDto;
import io.ana.julia.listinha.data.mapper.ItemMapper;
import io.ana.julia.listinha.data.mapper.UserMapper;
import io.ana.julia.listinha.exception.IdAlreadyExistsException;
import io.ana.julia.listinha.exception.IdNotExistsException;
import io.ana.julia.listinha.usecase.user.CreateUserUseCaseImpl;
import io.ana.julia.listinha.utils.DataFactoryItem;
import io.ana.julia.listinha.utils.DataFactoryUser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CreateItemUseCaseTest {

    private ItemRepository itemRepository;
    private ItemMapper itemMapper;
    private CreateItemUseCaseImpl createItemUseCase;

    @BeforeEach
    void setup() {
        itemRepository = Mockito.mock(ItemRepository.class);
        itemMapper = Mockito.mock(ItemMapper.class);
        createItemUseCase = new CreateItemUseCaseImpl(itemRepository,itemMapper);
    }

    @Test
    public void givenItemDTO_whenExecute_thenCreateItemWithSuccess() {
        when(itemRepository.existsById(any())).thenReturn(false);
        when(itemMapper.toItemEntity(any())).thenReturn(DataFactoryItem.itemEntity());
        when(itemRepository.save(any())).thenReturn(DataFactoryItem.itemEntity());

        ItemDto itemDto = createItemUseCase.execute(DataFactoryItem.itemDto());

        verify(itemRepository).existsById(any());
        verify(itemMapper).toItemEntity(any());
        verify(itemRepository).save(any());
    }

    @Test
    public void givenItemDTO_whenExecute_thenCreateItemWithFailure() {
        when(itemRepository.existsById(any())).thenReturn(true);

        Assertions.assertThrows(
                IdAlreadyExistsException.class, ()-> createItemUseCase.execute(DataFactoryItem.itemDto()));

        verify(itemRepository).existsById(any());
    }

}
