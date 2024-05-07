package io.ana.julia.listinha.usecase.item;

import io.ana.julia.listinha.data.dto.ItemDto;

public interface DeleteItemUseCase {

    public void execute(ItemDto itemDto, Long id);
}
