package io.ana.julia.listinha.usecase.item;

import io.ana.julia.listinha.data.ItemRepository;
import io.ana.julia.listinha.data.dto.ItemDto;
import io.ana.julia.listinha.data.dto.UserDto;
import io.ana.julia.listinha.data.mapper.ItemMapper;
import io.ana.julia.listinha.usecase.user.FindAllUsersUseCaseImpl;
import io.ana.julia.listinha.utils.AssertionItemData;
import io.ana.julia.listinha.utils.DataFactoryItem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

public class FindAllItensUseCaseTest {

    private static ItemRepository itemRepository;
    private static ItemMapper itemMapper;
    private static FindAllItensUseCaseImpl findAllItensUseCase;

    @BeforeEach
    void setup() {
        itemRepository = Mockito.mock(ItemRepository.class);
        itemMapper = Mockito.mock(ItemMapper.class);
        findAllItensUseCase = new FindAllItensUseCaseImpl(itemRepository,itemMapper);
    }

    @Test
    public void givenNotAttributes_whenExecute_thenFindAllItens() {
        when(itemRepository.findAll()).thenReturn(
                List.of(DataFactoryItem.itemEntity(),
                        DataFactoryItem.itemEntity(),
                        DataFactoryItem.itemEntity()));
        when(itemMapper.toItemDTO(any())).thenReturn(DataFactoryItem.itemDto());
        List<ItemDto> dtoList = findAllItensUseCase.execute();
        ItemDto itemDto = dtoList.get(2);
        Assertions.assertEquals(dtoList.size(), 3);
        AssertionItemData.assertMapperItemEquals(itemDto,DataFactoryItem.itemDto());
        Assertions.assertNotNull(dtoList);

        verify(itemRepository).findAll();
        verify(itemMapper,times(3)).toItemDTO(any());
    }

    @Test
    public void givenNotAttributes_whenExecute_thenFindAllItensEmpyt() {
        when(itemRepository.findAll()).thenReturn(List.of());
        List<ItemDto> dtoList = findAllItensUseCase.execute();

        Assertions.assertEquals(dtoList.size(), 0);

        verify(itemMapper,never()).toItemDTO(any());
    }
}
