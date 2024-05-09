package io.ana.julia.listinha.usecase.shoppinglist;

import io.ana.julia.listinha.data.dto.ShoppingListDto;

public interface CreateShoppingListUseCase {

    ShoppingListDto execute(ShoppingListDto shoppingListDto);
}
