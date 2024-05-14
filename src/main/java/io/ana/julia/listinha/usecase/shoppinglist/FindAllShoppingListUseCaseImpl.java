package io.ana.julia.listinha.usecase.shoppinglist;

import io.ana.julia.listinha.data.ShoppingListRepository;
import io.ana.julia.listinha.data.dto.ShoppingListDto;
import io.ana.julia.listinha.data.mapper.ShoppingListMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FindAllShoppingListUseCaseImpl implements FindAllShoppingListUseCase {

    private final ShoppingListRepository shoppingListRepository;
    private final ShoppingListMapper shoppingListMapper;

    public FindAllShoppingListUseCaseImpl(
            ShoppingListRepository shoppingListRepository,
            ShoppingListMapper shoppingListMapper) {
        this.shoppingListRepository = shoppingListRepository;
        this.shoppingListMapper = shoppingListMapper;
    }

    @Override
    public List<ShoppingListDto> execute() {
        return shoppingListRepository.
                findAll().
                stream().
                map(listEntity -> shoppingListMapper.toListDTO(listEntity)).
                collect(Collectors.toList());
    }
}
