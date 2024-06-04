package io.ana.julia.listinha.usecase.shoppinglist;

import io.ana.julia.listinha.data.ItemRepository;
import io.ana.julia.listinha.data.ShoppingListItemRepository;
import io.ana.julia.listinha.data.ShoppingListRepository;
import io.ana.julia.listinha.data.UserRepository;
import io.ana.julia.listinha.data.mapper.ShoppingListItemMapper;
import io.ana.julia.listinha.exception.IdNotExistsException;
import io.ana.julia.listinha.utils.DataFactoryItem;
import io.ana.julia.listinha.utils.DataFactoryShoppingList;
import io.ana.julia.listinha.utils.DataFactoryShoppingListItem;
import io.ana.julia.listinha.utils.DataFactoryUser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class AddItemOnShoppingListUseCaseTest {


    private ShoppingListRepository shoppingListRepository;
    private ShoppingListItemRepository shoppingListItemRepository;
    private ShoppingListItemMapper shoppingListMapper;
    private UserRepository userRepository;
    private ItemRepository itemRepository;
    private AddItemOnShoppingListUseCaseImpl addItemOnShoppingListUseCase;

    @BeforeEach
    void setup() {
        shoppingListRepository = Mockito.mock(ShoppingListRepository.class);
        shoppingListItemRepository = Mockito.mock(ShoppingListItemRepository.class);
        shoppingListMapper = Mockito.mock(ShoppingListItemMapper.class);
        userRepository = Mockito.mock(UserRepository.class);
        itemRepository = Mockito.mock(ItemRepository.class);
        addItemOnShoppingListUseCase = new AddItemOnShoppingListUseCaseImpl(
                shoppingListRepository,
                shoppingListItemRepository,
                shoppingListMapper,
                userRepository,
                itemRepository);
    }

    @Test
    public void givenUserIdItemIdAndListId_whenExecute_thenAddShoppingListItemWithSuccess() {
       when(shoppingListRepository.findById(anyLong())).thenReturn(Optional.of(DataFactoryShoppingList.listEntity()));
       when(userRepository.existsById(anyLong())).thenReturn(true);
       when(itemRepository.findById(anyLong())).thenReturn(Optional.of(DataFactoryItem.itemEntity()));

       addItemOnShoppingListUseCase.execute(
               DataFactoryUser.userDTO().getId(),
               DataFactoryItem.itemDto().getId(),
               DataFactoryShoppingList.listDto().getId());

       verify(shoppingListRepository).findById(anyLong());
       verify(userRepository).existsById(anyLong());
       verify(itemRepository).findById(anyLong());
    }

    @Test
    public void givenShoppingListId_whenGetListById_thenListNotExists() {
        when(shoppingListRepository.findById(anyLong())).thenReturn(Optional.empty());

        Assertions.assertThrows(IdNotExistsException.class, () ->
                addItemOnShoppingListUseCase.execute(
                        DataFactoryUser.userDTO().getId(),
                        DataFactoryItem.itemDto().getId(),
                        DataFactoryShoppingList.listDto().getId()));

        verify(shoppingListRepository).findById(anyLong());
    }

    @Test
    public void givenItemId_whenExistsById_thenItemNotExists() {
        when(shoppingListRepository.findById(anyLong())).thenReturn(Optional.of(DataFactoryShoppingList.listEntity()));
        when(userRepository.existsById(anyLong())).thenReturn(false);

        Assertions.assertThrows(IdNotExistsException.class, () ->
                addItemOnShoppingListUseCase.execute(
                        DataFactoryUser.userDTO().getId(),
                        DataFactoryItem.itemDto().getId(),
                        DataFactoryShoppingList.listDto().getId()));

        verify(shoppingListRepository).findById(anyLong());
        verify(userRepository).existsById(anyLong());
    }

    @Test
    public void givenItemId_whenExistsById_thenUserNotExists() {
        when(shoppingListRepository.findById(anyLong())).thenReturn(Optional.of(DataFactoryShoppingList.listEntity()));
        when(userRepository.existsById(anyLong())).thenReturn(true);
        when(itemRepository.findById(anyLong())).thenReturn(Optional.empty());

        Assertions.assertThrows(IdNotExistsException.class, () ->
                addItemOnShoppingListUseCase.execute(
                        DataFactoryUser.userDTO().getId(),
                        DataFactoryItem.itemDto().getId(),
                        DataFactoryShoppingList.listDto().getId()));

        verify(shoppingListRepository).findById(anyLong());
        verify(userRepository).existsById(anyLong());
        verify(itemRepository).findById(anyLong());
    }
}
