package io.ana.julia.listinha.usecase.shoppinglist;

import io.ana.julia.listinha.data.ShoppingListItemRepository;
import io.ana.julia.listinha.exception.IdNotExistsException;
import org.springframework.stereotype.Service;

@Service
public class RemoveItemOnShoppingListUseCaseImpl implements RemoveItemOnShoppingListUseCase {

    private final ShoppingListItemRepository shoppingListItemRepository;

    public RemoveItemOnShoppingListUseCaseImpl(
            ShoppingListItemRepository shoppingListItemRepository) {
        this.shoppingListItemRepository = shoppingListItemRepository;
    }

    private void existsShoppingListItemById(Long id) {
        if (!shoppingListItemRepository.existsById(id)) {
            throw new IdNotExistsException("Lista nao encontrada");
        }
    }

    @Override
    public void execute(Long shoppingListItemId) {
        existsShoppingListItemById(shoppingListItemId);
        shoppingListItemRepository.deleteById(shoppingListItemId);
    }
}
