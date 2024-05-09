package io.ana.julia.listinha.usecase.shoppinglist;

import io.ana.julia.listinha.data.ShoppingListRepository;
import io.ana.julia.listinha.data.mapper.ShoppingListMapper;
import io.ana.julia.listinha.exception.IdNotExistsException;
import io.ana.julia.listinha.utils.DataFactoryShoppingList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class DeleteShoppingListUseCaseTest {
    private ShoppingListRepository shoppingListRepository;
    private ShoppingListMapper shoppingListMapper;
    private DeleteShoppingListUseCaseImpl deleteListUseCase;

    @BeforeEach
    void setup() {
        shoppingListRepository = Mockito.mock(ShoppingListRepository.class);
        shoppingListMapper = Mockito.mock(ShoppingListMapper.class);
        deleteListUseCase = new DeleteShoppingListUseCaseImpl(shoppingListRepository, shoppingListMapper);
    }

    @Test
    public void givenIdList_whenExecute_thenDeleteListWithSuccess() {
        when(shoppingListRepository.findById(anyLong())).thenReturn(Optional.of(DataFactoryShoppingList.listEntity()));
        doNothing().when(shoppingListRepository).deleteById(anyLong());
        deleteListUseCase.execute(DataFactoryShoppingList.listEntity().getId());

        verify(shoppingListRepository).findById(anyLong());
        verify(shoppingListRepository).deleteById(anyLong());
    }

    @Test
    public void givenIdList_whenExecute_thenDeleteListWithFailure() {
        when(shoppingListRepository.findById(anyLong())).thenReturn(Optional.empty());

        Assertions.assertThrows(IdNotExistsException.class,
                ()-> deleteListUseCase.execute(DataFactoryShoppingList.listEntity().getId()));

        verify(shoppingListRepository).findById(anyLong());
    }
}
