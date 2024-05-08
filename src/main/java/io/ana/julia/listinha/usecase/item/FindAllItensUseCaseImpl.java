package io.ana.julia.listinha.usecase.item;

import io.ana.julia.listinha.data.ItemRepository;
import io.ana.julia.listinha.data.dto.ItemDto;
import io.ana.julia.listinha.data.entity.ItemEntity;
import io.ana.julia.listinha.data.mapper.ItemMapper;

import java.util.List;
import java.util.stream.Collectors;

public class FindAllItensUseCaseImpl implements FindAllItensUseCase{

    private final ItemRepository itemRepository;
    private final ItemMapper itemMapper;

    public FindAllItensUseCaseImpl(
            ItemRepository itemRepository,
            ItemMapper itemMapper) {
        this.itemRepository = itemRepository;
        this.itemMapper = itemMapper;
    }

    @Override
    public List<ItemDto> execute() {
        return itemRepository
                .findAll().
                stream().
                map(itemEntity -> itemMapper.toItemDTO(itemEntity)).
                collect(Collectors.toList());
    }
}
