package io.ana.julia.listinha.usecase.item;

import io.ana.julia.listinha.data.ItemRepository;
import io.ana.julia.listinha.data.dto.ItemDto;
import io.ana.julia.listinha.data.entity.ItemEntity;
import io.ana.julia.listinha.data.entity.UserEntity;
import io.ana.julia.listinha.data.mapper.ItemMapper;
import io.ana.julia.listinha.exception.IdNotExistsException;
import org.springframework.stereotype.Component;

@Component
public class DeleteItemUseCaseImpl implements DeleteItemUseCase{

    private final ItemRepository itemRepository;
    private final ItemMapper itemMapper;

    public DeleteItemUseCaseImpl(
            ItemRepository itemRepository,
            ItemMapper itemMapper) {
        this.itemRepository = itemRepository;
        this.itemMapper = itemMapper;
    }

    private void findItemExistsById(Long id){
        if(!itemRepository.existsById(id)) {
            throw new IdNotExistsException("Item nao existente");
        }
    }

    @Override
    public void execute(ItemDto itemDto, Long id) {
        findItemExistsById(itemDto.getId());
        ItemEntity itemEntity = itemMapper.toItemEntity(itemDto);
        itemRepository.delete(itemEntity);

    }
}
