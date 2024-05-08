package io.ana.julia.listinha.usecase.item;

import io.ana.julia.listinha.data.dto.ItemDto;

public interface CreateItemUseCase {

    public ItemDto execute(ItemDto itemDto);
}
