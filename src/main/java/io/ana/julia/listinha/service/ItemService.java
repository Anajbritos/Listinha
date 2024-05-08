package io.ana.julia.listinha.service;

import io.ana.julia.listinha.data.dto.ItemDto;

import java.util.List;

public interface ItemService {

    public ItemDto createItem(ItemDto itemDto);
    public void deleteItem(Long id);
    public ItemDto updateItem(ItemDto itemDto);
    public List<ItemDto> findAllItems();
}
