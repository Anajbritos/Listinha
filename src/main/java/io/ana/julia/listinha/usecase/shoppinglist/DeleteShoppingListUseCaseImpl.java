package io.ana.julia.listinha.usecase.shoppinglist;

import io.ana.julia.listinha.data.ShoppingListRepository;
import io.ana.julia.listinha.data.mapper.ShoppingListMapper;
import io.ana.julia.listinha.exception.IdNotExistsException;
import org.springframework.stereotype.Service;

@Service
public class DeleteShoppingListUseCaseImpl implements DeleteShoppingListUseCase {

    private final ShoppingListRepository shoppingListRepository;
    private final ShoppingListMapper shoppingListMapper;

    public DeleteShoppingListUseCaseImpl(
            ShoppingListRepository shoppingListRepository,
            ShoppingListMapper shoppingListMapper) {
        this.shoppingListRepository = shoppingListRepository;
        this.shoppingListMapper = shoppingListMapper;
    }

    private void searchExistingListById(Long id) {
        if(shoppingListRepository.findById(id).isEmpty()){
            throw new IdNotExistsException("Lista não cadastrada");
        }
    }

    @Override
    public void execute(Long id) {
        searchExistingListById(id);
        shoppingListRepository.deleteById(id);
    }
}
