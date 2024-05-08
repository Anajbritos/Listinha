package io.ana.julia.listinha.usecase.item;

import io.ana.julia.listinha.data.dto.ItemDto;

import java.util.List;

public interface FindAllItensUseCase {

    public List<ItemDto> execute();
}
