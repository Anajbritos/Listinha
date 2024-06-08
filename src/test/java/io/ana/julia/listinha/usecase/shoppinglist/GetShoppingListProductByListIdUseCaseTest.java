package io.ana.julia.listinha.usecase.shoppinglist;

import io.ana.julia.listinha.data.ItemRepository;
import io.ana.julia.listinha.data.ShoppingListItemRepository;
import io.ana.julia.listinha.data.ShoppingListRepository;
import io.ana.julia.listinha.data.UserRepository;
import io.ana.julia.listinha.data.mapper.ItemMapper;
import io.ana.julia.listinha.data.mapper.ShoppingListItemMapper;
import io.ana.julia.listinha.data.mapper.ShoppingListMapper;
import io.ana.julia.listinha.utils.DataFactoryItem;
import io.ana.julia.listinha.utils.DataFactoryShoppingList;
import io.ana.julia.listinha.utils.DataFactoryShoppingListItem;
import io.ana.julia.listinha.utils.DataFactoryUser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class GetShoppingListItemByListIdUseCaseTest {


    private ShoppingListItemRepository shoppingListItemRepository;
    private ShoppingListMapper shoppingListMapper;
    private ShoppingListItemMapper shoppingListItemMapper;
    private ItemMapper itemMapper;
    private GetShoppingListItemByListIdUseCaseImpl getShoppingListItemByListIdUseCase;

    @BeforeEach
    void setup() {
        shoppingListItemRepository = Mockito.mock(ShoppingListItemRepository.class);
        shoppingListMapper = Mockito.mock(ShoppingListMapper.class);
        shoppingListItemMapper = Mockito.mock(ShoppingListItemMapper.class);
        itemMapper = Mockito.mock(ItemMapper.class);
        getShoppingListItemByListIdUseCase = new GetShoppingListItemByListIdUseCaseImpl(
                shoppingListItemRepository,
                shoppingListMapper,
                shoppingListItemMapper,
                itemMapper);
    }

    @Test
    public void givenShoppingListId_whenExecute_thenGetAllShoppingListItemWithSuccess() {
        when(shoppingListItemRepository.findAllByShoppingListId(anyLong())).
                thenReturn(List.of(
                        DataFactoryShoppingListItem.shoppingListItemEntity(),
                        DataFactoryShoppingListItem.shoppingListItemEntity()));

    }
}
