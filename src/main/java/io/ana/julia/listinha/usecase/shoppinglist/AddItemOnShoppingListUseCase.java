package io.ana.julia.listinha.usecase.shoppinglist;

import io.ana.julia.listinha.data.dto.ShoppingListDto;
import io.ana.julia.listinha.data.dto.ShoppingListItemDto;

import java.util.List;

public interface AddItemOnShoppingListUseCase {

    public ShoppingListItemDto execute(Long user, Long item, Long list);
}
