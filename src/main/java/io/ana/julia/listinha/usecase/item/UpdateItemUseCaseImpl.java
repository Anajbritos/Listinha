package io.ana.julia.listinha.usecase.item;

import io.ana.julia.listinha.data.ItemRepository;
import io.ana.julia.listinha.data.dto.ItemDto;
import io.ana.julia.listinha.data.dto.UserDto;
import io.ana.julia.listinha.data.entity.ItemEntity;
import io.ana.julia.listinha.data.entity.UserEntity;
import io.ana.julia.listinha.data.mapper.ItemMapper;
import io.ana.julia.listinha.exception.IdNotExistsException;

public class UpdateItemUseCaseImpl implements UpdateItemUseCase{

    private final ItemRepository itemRepository;
    private final ItemMapper itemMapper;

    public UpdateItemUseCaseImpl(
            ItemRepository itemRepository,
            ItemMapper itemMapper) {
        this.itemRepository = itemRepository;
        this.itemMapper = itemMapper;
    }

    public void findUserExistsById(Long id) {
        if(!itemRepository.existsById(id)){
            throw new IdNotExistsException("Item não cadastrado");
        }
    }

    @Override
    public ItemDto execute(ItemDto itemDto) {
        findUserExistsById(itemDto.getId());
        ItemEntity itemEntity = itemMapper.toItemEntity(itemDto);
        itemRepository.save(itemEntity);
        return itemMapper.toItemDTO(itemEntity);
    }
}
