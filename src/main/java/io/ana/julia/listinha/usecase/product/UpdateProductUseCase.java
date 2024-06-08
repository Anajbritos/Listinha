package io.ana.julia.listinha.usecase.item;

import io.ana.julia.listinha.data.dto.ItemDto;

public interface UpdateItemUseCase {

    ItemDto execute(ItemDto itemDto);
}
