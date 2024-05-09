package io.ana.julia.listinha.usecase.user;

import io.ana.julia.listinha.data.ShoppingListRepository;
import io.ana.julia.listinha.data.dto.ShoppingListDto;
import io.ana.julia.listinha.data.dto.UserDto;

import java.util.List;

public interface GetListByUserUseCase {

    public List<ShoppingListDto> execute(Long id);
}
