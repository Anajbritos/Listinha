package io.ana.julia.listinha.service;

import io.ana.julia.listinha.data.dto.ShoppingListDto;

import java.util.List;

public interface ShoppingListService {

    ShoppingListDto createList(ShoppingListDto shoppingListDto);
    void deleteList(Long id);
    ShoppingListDto updateList(ShoppingListDto shoppingListDto);
    List<ShoppingListDto> findAllLists();
}
