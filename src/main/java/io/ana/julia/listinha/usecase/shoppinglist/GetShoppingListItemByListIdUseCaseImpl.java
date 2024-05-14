package io.ana.julia.listinha.usecase.shoppinglist;

import io.ana.julia.listinha.data.ShoppingListItemRepository;
import io.ana.julia.listinha.data.dto.ShoppingListItemDto;
import io.ana.julia.listinha.data.mapper.ItemMapper;
import io.ana.julia.listinha.data.mapper.ShoppingListItemMapper;
import io.ana.julia.listinha.data.mapper.ShoppingListMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GetShoppingListItemByListIdUseCaseImpl implements GetShoppingListItemByListIdUseCase{

    private final ShoppingListItemRepository shoppingListItemRepository;
    private final ShoppingListMapper shoppingListMapper;
    private final ShoppingListItemMapper shoppingListItemMapper;
    private final ItemMapper itemMapper;

    public GetShoppingListItemByListIdUseCaseImpl(
            ShoppingListItemRepository shoppingListItemRepository,
            ShoppingListMapper shoppingListMapper,
            ShoppingListItemMapper shoppingListItemMapper,
            ItemMapper itemMapper ) {
        this.shoppingListItemRepository = shoppingListItemRepository;
        this.shoppingListMapper = shoppingListMapper;
        this.shoppingListItemMapper = shoppingListItemMapper;
        this.itemMapper = itemMapper;
    }

    @Override
    public List<ShoppingListItemDto> execute(Long shoppingListId) {
        return shoppingListItemRepository.
                findAllByShoppingListId(shoppingListId).
                stream().
                map(shoppingListItemEntity ->
                        shoppingListItemMapper.toShoppingListItemDto(
                                shoppingListItemEntity,
                                itemMapper.toItemDTO(shoppingListItemEntity.getItem()),
                                shoppingListMapper.toListDTO(shoppingListItemEntity.getShoppingList()))).
                collect(Collectors.toList());
    }
}
