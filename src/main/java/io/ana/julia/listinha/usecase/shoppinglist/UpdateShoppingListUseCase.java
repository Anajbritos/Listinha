package io.ana.julia.listinha.usecase.shoppinglist;

import io.ana.julia.listinha.data.dto.ShoppingListDto;

public interface UpdateShoppingListUseCase {

    ShoppingListDto execute(ShoppingListDto shoppingListDto);
}
