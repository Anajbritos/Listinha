package io.ana.julia.listinha.usecase.item;

import io.ana.julia.listinha.data.ItemRepository;
import io.ana.julia.listinha.data.dto.ItemDto;
import io.ana.julia.listinha.data.mapper.ItemMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class FindAllItemsUseCaseImpl implements FindAllItemsUseCase {

    private final ItemRepository itemRepository;
    private final ItemMapper itemMapper;

    public FindAllItemsUseCaseImpl(
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
