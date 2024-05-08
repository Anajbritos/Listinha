package io.ana.julia.listinha.usecase.item;

import io.ana.julia.listinha.data.ItemRepository;
import io.ana.julia.listinha.data.dto.ItemDto;
import io.ana.julia.listinha.data.entity.ItemEntity;
import io.ana.julia.listinha.data.entity.UserEntity;
import io.ana.julia.listinha.data.mapper.ItemMapper;
import io.ana.julia.listinha.exception.IdAlreadyExistsException;
import io.ana.julia.listinha.exception.IdNotExistsException;
import org.springframework.stereotype.Component;

@Component
public class CreateItemUseCaseImpl implements CreateItemUseCase{

    private final ItemRepository itemRepository;
    private final ItemMapper itemMapper;

    public  CreateItemUseCaseImpl(
            ItemRepository itemRepository,
            ItemMapper itemMapper) {

        this.itemRepository = itemRepository;
        this.itemMapper = itemMapper;
    }

    private void existsByDescription(String description){
        if(itemRepository.existsByDescription(description)) {
            throw new IdAlreadyExistsException("Item ja existente");
        }
    }

    @Override
    public ItemDto execute(ItemDto itemDto) {
        existsByDescription(itemDto.getDescription());
        ItemEntity itemEntity = itemRepository.save(itemMapper.toItemEntity(itemDto));
        return itemMapper.toItemDTO(itemEntity);
    }
}
