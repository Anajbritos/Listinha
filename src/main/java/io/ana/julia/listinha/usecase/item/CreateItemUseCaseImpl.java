package io.ana.julia.listinha.usecase.item;

import io.ana.julia.listinha.data.ItemRepository;
import io.ana.julia.listinha.data.dto.ItemDto;
import io.ana.julia.listinha.data.entity.ItemEntity;
import io.ana.julia.listinha.data.entity.UserEntity;
import io.ana.julia.listinha.data.mapper.ItemMapper;
import io.ana.julia.listinha.exception.IdNotExistsException;
import org.springframework.stereotype.Component;

@Component
public class CreateItemUseCaseImpl implements CreateItemUseCase{

    private static ItemRepository itemRepository;
    private static ItemMapper itemMapper;

    public  CreateItemUseCaseImpl(
            ItemRepository itemRepository,
            ItemMapper itemMapper) {

        this.itemRepository = itemRepository;
        this.itemMapper = itemMapper;
    }

    public void findItemExistsById(Long id){
        if(itemRepository.existsById(id)) {
            throw new IdNotExistsException("Item ja existente");
        }
    }

    @Override
    public ItemDto execute(ItemDto itemDto) {
        findItemExistsById(itemDto.getId());
        ItemEntity itemEntity = itemRepository.save(itemMapper.toItemEntity(itemDto));
        return itemMapper.toItemDTO(itemEntity);
    }
}
