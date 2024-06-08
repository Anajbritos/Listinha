package io.ana.julia.listinha.service;

import io.ana.julia.listinha.data.dto.ItemDto;
import io.ana.julia.listinha.usecase.item.CreateItemUseCase;
import io.ana.julia.listinha.usecase.item.DeleteItemUseCase;
import io.ana.julia.listinha.usecase.item.FindAllItemsUseCase;
import io.ana.julia.listinha.usecase.item.UpdateItemUseCase;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService{

    private final CreateItemUseCase createItemUseCase;
    private final DeleteItemUseCase deleteItemUseCase;
    private final UpdateItemUseCase updateItemUseCase;
    private final FindAllItemsUseCase findAllItemsUseCase;

    public ItemServiceImpl(
            CreateItemUseCase createItemUseCase,
            DeleteItemUseCase deleteItemUseCase,
            UpdateItemUseCase updateItemUseCase,
            FindAllItemsUseCase findAllItemsUseCase) {
        this.createItemUseCase = createItemUseCase;
        this.deleteItemUseCase = deleteItemUseCase;
        this.updateItemUseCase = updateItemUseCase;
        this.findAllItemsUseCase = findAllItemsUseCase;
    }

    @Override
    public ItemDto createItem(ItemDto itemDto) {
        return createItemUseCase.execute(itemDto);
    }

    @Override
    public void deleteItem(Long id) {
        deleteItemUseCase.execute(id);
    }

    @Override
    public ItemDto updateItem(ItemDto itemDto) {
        return updateItemUseCase.execute(itemDto);
    }

    @Override
    public List<ItemDto> findAllItems() {
        return findAllItemsUseCase.execute();
    }
}
