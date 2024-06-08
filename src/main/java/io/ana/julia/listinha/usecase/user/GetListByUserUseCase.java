package io.ana.julia.listinha.usecase.user;

import io.ana.julia.listinha.data.dto.ShoppingListDto;

import java.util.List;

public interface GetListByUserUseCase {

    List<ShoppingListDto> execute(Long id);
}
