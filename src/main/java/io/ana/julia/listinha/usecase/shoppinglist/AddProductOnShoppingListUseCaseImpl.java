package io.ana.julia.listinha.usecase.shoppinglist;

import io.ana.julia.listinha.data.ItemRepository;
import io.ana.julia.listinha.data.ShoppingListItemRepository;
import io.ana.julia.listinha.data.ShoppingListRepository;
import io.ana.julia.listinha.data.UserRepository;
import io.ana.julia.listinha.data.entity.ItemEntity;
import io.ana.julia.listinha.data.entity.ShoppingListEntity;
import io.ana.julia.listinha.data.mapper.ShoppingListItemMapper;
import io.ana.julia.listinha.exception.IdNotExistsException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AddItemOnShoppingListUseCaseImpl implements AddItemOnShoppingListUseCase {

    private final ShoppingListRepository shoppingListRepository;
    private final ShoppingListItemRepository shoppingListItemRepository;
    private final ShoppingListItemMapper shoppingListMapper;
    private final UserRepository userRepository;
    private final ItemRepository itemRepository;


    public AddItemOnShoppingListUseCaseImpl(
            ShoppingListRepository shoppingListRepository,
            ShoppingListItemRepository shoppingListItemRepository,
            ShoppingListItemMapper shoppingListMapper,
            UserRepository userRepository,
            ItemRepository itemRepository) {
        this.shoppingListRepository = shoppingListRepository;
        this.shoppingListItemRepository = shoppingListItemRepository;
        this.shoppingListMapper = shoppingListMapper;
        this.userRepository = userRepository;
        this.itemRepository = itemRepository;
    }

    private ShoppingListEntity getListById(Long id) {
        Optional<ShoppingListEntity> shoppingListEntity = shoppingListRepository.findById(id);
        if (shoppingListEntity.isEmpty()) {
            throw new IdNotExistsException("lista não existe");
        }
        return shoppingListEntity.get();
    }

    private void existsById(Long id) {
        if (!userRepository.existsById(id)) {
            throw new IdNotExistsException("Usuario nao encontrado");
        }
    }

    private ItemEntity getItemById(Long id) {
        Optional<ItemEntity> itemEntity = itemRepository.findById(id);
        if (itemEntity.isEmpty()) {
            throw new IdNotExistsException("Produto não encontrado");
        }
        return itemEntity.get();
    }

    @Override
    public void execute(Long user, Long item, Long list) {
        ShoppingListEntity shoppingListEntity = getListById(list);
        existsById(user);
        ItemEntity itemEntity = getItemById(item);
        shoppingListItemRepository.save(
                shoppingListMapper.toShoppingListItemEntity(
                        shoppingListEntity,
                        itemEntity
                )
        );

    }
}
