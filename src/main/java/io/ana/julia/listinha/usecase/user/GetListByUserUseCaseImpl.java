package io.ana.julia.listinha.usecase.user;

import io.ana.julia.listinha.data.ShoppingListRepository;
import io.ana.julia.listinha.data.UserRepository;
import io.ana.julia.listinha.data.dto.ShoppingListDto;
import io.ana.julia.listinha.data.entity.UserEntity;
import io.ana.julia.listinha.data.mapper.ShoppingListMapper;
import io.ana.julia.listinha.exception.IdNotExistsException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class GetListByUserUseCaseImpl implements GetListByUserUseCase{

    private final UserRepository userRepository;
    private final ShoppingListRepository shoppingListRepository;
    private final ShoppingListMapper shoppingListMapper;

    public GetListByUserUseCaseImpl(
            UserRepository userRepository,
            ShoppingListRepository shoppingListRepository,
            ShoppingListMapper shoppingListMapper) {
        this.userRepository = userRepository;
        this.shoppingListRepository = shoppingListRepository;
        this.shoppingListMapper = shoppingListMapper;
    }

    private void findUserById(Long id) {
        if(!userRepository.existsById(id)) {
            throw new IdNotExistsException("Usuario nao existente");
        }
    }

    @Override
    public List<ShoppingListDto> execute(Long id) {
        findUserById(id);
        return shoppingListRepository.
                findAllByUserId(id).
                stream().map(shoppingListEntity -> shoppingListMapper.toListDTO(shoppingListEntity)).
                collect(Collectors.toList());
    }
}
