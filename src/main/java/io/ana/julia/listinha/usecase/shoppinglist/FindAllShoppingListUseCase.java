package io.ana.julia.listinha.usecase.shoppinglist;

import io.ana.julia.listinha.data.dto.ShoppingListDto;

import java.util.List;

public interface FindAllShoppingListUseCase {

    List<ShoppingListDto> execute();
}
