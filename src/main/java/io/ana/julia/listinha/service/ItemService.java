package io.ana.julia.listinha.service;

import io.ana.julia.listinha.data.dto.ItemDto;

import java.util.List;

public interface ItemService {

    ItemDto createItem(ItemDto itemDto);
    void deleteItem(Long id);
    ItemDto updateItem(ItemDto itemDto);
    List<ItemDto> findAllItems();
}
