package io.ana.julia.listinha.service;

import io.ana.julia.listinha.data.dto.ShoppingListItemDto;
import io.ana.julia.listinha.usecase.shoppinglist.AddItemOnShoppingListUseCase;
import io.ana.julia.listinha.usecase.shoppinglist.GetShoppingListItemByListIdUseCase;
import io.ana.julia.listinha.usecase.shoppinglist.RemoveItemOnShoppingListUseCase;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingListItemServiceImpl implements ShoppingListItemService {

    private final AddItemOnShoppingListUseCase addItemOnShoppingListUseCase;
    private final RemoveItemOnShoppingListUseCase removeItemOnShoppingListUseCase;
    private final GetShoppingListItemByListIdUseCase getShoppingListItemByListIdUseCase;

    public ShoppingListItemServiceImpl(
            AddItemOnShoppingListUseCase addItemOnShoppingListUseCase,
            RemoveItemOnShoppingListUseCase removeItemOnShoppingListUseCase,
            GetShoppingListItemByListIdUseCase getShoppingListItemByListIdUseCase) {
        this.addItemOnShoppingListUseCase = addItemOnShoppingListUseCase;
        this.removeItemOnShoppingListUseCase = removeItemOnShoppingListUseCase;
        this.getShoppingListItemByListIdUseCase = getShoppingListItemByListIdUseCase;
    }

    @Override
    public List<ShoppingListItemDto> addItemOnShoppingList(Long userId, Long itemId, Long shoppingListId) {
        addItemOnShoppingListUseCase.execute(userId, itemId, shoppingListId);
        return getShoppingListItemByListIdUseCase.execute(shoppingListId);
    }

    @Override
    public List<ShoppingListItemDto> removeItemOnShoppingList(Long shoppingListItemId, Long shoppingListId) {
        removeItemOnShoppingListUseCase.execute(shoppingListItemId);
        return getShoppingListItemByListIdUseCase.execute(shoppingListId);
    }
}
