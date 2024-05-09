package io.ana.julia.listinha.service;

import io.ana.julia.listinha.data.dto.ShoppingListDto;
import io.ana.julia.listinha.usecase.shoppinglist.CreateShoppingListUseCase;
import io.ana.julia.listinha.usecase.shoppinglist.DeleteShoppingListUseCase;
import io.ana.julia.listinha.usecase.shoppinglist.FindAllShoppingListUseCase;
import io.ana.julia.listinha.usecase.shoppinglist.UpdateShoppingListUseCase;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingShoppingListServiceImpl implements ShoppingListService {

    public CreateShoppingListUseCase createShoppingListUseCase;
    public DeleteShoppingListUseCase deleteShoppingListUseCase;
    public UpdateShoppingListUseCase updateShoppingListUseCase;
    public FindAllShoppingListUseCase findAllShoppingListUseCase;

    public ShoppingShoppingListServiceImpl(CreateShoppingListUseCase createShoppingListUseCase,
                                           DeleteShoppingListUseCase deleteShoppingListUseCase,
                                           UpdateShoppingListUseCase updateShoppingListUseCase,
                                           FindAllShoppingListUseCase findAllShoppingListUseCase) {
        this.createShoppingListUseCase = createShoppingListUseCase;
        this.deleteShoppingListUseCase = deleteShoppingListUseCase;
        this.updateShoppingListUseCase = updateShoppingListUseCase;
        this.findAllShoppingListUseCase = findAllShoppingListUseCase;
    }

    @Override
    public ShoppingListDto createList(ShoppingListDto shoppingListDto) {
        return createShoppingListUseCase.execute(shoppingListDto);
    }

    @Override
    public void deleteList(Long id) {
        deleteShoppingListUseCase.execute(id);
    }

    @Override
    public ShoppingListDto updateList(ShoppingListDto shoppingListDto) {
        return updateShoppingListUseCase.execute(shoppingListDto);
    }

    @Override
    public List<ShoppingListDto> findAllLists() {
        return findAllShoppingListUseCase.execute();
    }
}
