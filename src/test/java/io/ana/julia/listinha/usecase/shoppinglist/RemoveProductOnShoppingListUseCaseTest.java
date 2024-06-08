package io.ana.julia.listinha.usecase.shoppinglist;

import io.ana.julia.listinha.data.ShoppingListItemRepository;
import io.ana.julia.listinha.exception.IdNotExistsException;
import io.ana.julia.listinha.utils.DataFactoryShoppingListItem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class RemoveItemOnShoppingListUseCaseTest {


    private ShoppingListItemRepository shoppingListItemRepository;
    private RemoveItemOnShoppingListUseCaseImpl removeItemOnShoppingListUseCase;

    @BeforeEach
    void setup() {
        shoppingListItemRepository = Mockito.mock(ShoppingListItemRepository.class);
        removeItemOnShoppingListUseCase = new RemoveItemOnShoppingListUseCaseImpl(
                shoppingListItemRepository);
    }

    @Test
    public void givenIdListItem_whenExecute_thenRemoveShoppingListItemWithSuccess() {
       when(shoppingListItemRepository.existsById(anyLong())).thenReturn(true);
       doNothing().when(shoppingListItemRepository).deleteById(anyLong());
      removeItemOnShoppingListUseCase.execute(DataFactoryShoppingListItem.shoppingListItemDto().getId());

       verify(shoppingListItemRepository).existsById(anyLong());
       verify(shoppingListItemRepository).deleteById(anyLong());
    }

    @Test
    public void givenIdListItem_whenExecute_thenRemoveShoppingListItemWithFailure() {
        when(shoppingListItemRepository.existsById(anyLong())).thenReturn(false);

        Assertions.assertThrows(IdNotExistsException.class,()->
            removeItemOnShoppingListUseCase.
                    execute(DataFactoryShoppingListItem.shoppingListItemDto().getId()));

        verify(shoppingListItemRepository).existsById(anyLong());
    }
}
