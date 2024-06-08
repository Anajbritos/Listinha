package io.ana.julia.listinha.usecase.shoppinglist;

import io.ana.julia.listinha.data.dto.ShoppingListItemDto;

import java.util.List;

public interface GetShoppingListItemByListIdUseCase {

    public List<ShoppingListItemDto> execute(Long shoppingListId);
}
