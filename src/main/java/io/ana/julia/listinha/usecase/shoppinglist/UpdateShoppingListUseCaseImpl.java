package io.ana.julia.listinha.usecase.shoppinglist;

import io.ana.julia.listinha.data.ShoppingListRepository;
import io.ana.julia.listinha.data.UserRepository;
import io.ana.julia.listinha.data.dto.ShoppingListDto;
import io.ana.julia.listinha.data.entity.ShoppingListEntity;
import io.ana.julia.listinha.data.entity.UserEntity;
import io.ana.julia.listinha.data.mapper.ShoppingListMapper;
import io.ana.julia.listinha.exception.DescriptionAlreadyExistsException;
import io.ana.julia.listinha.exception.IdNotExistsException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UpdateShoppingListUseCaseImpl implements UpdateShoppingListUseCase {

    private final ShoppingListRepository shoppingListRepository;
    private final UserRepository userRepository;
    private final ShoppingListMapper shoppingListMapper;

    public UpdateShoppingListUseCaseImpl(
            ShoppingListRepository shoppingListRepository,
            UserRepository userRepository,
            ShoppingListMapper shoppingListMapper) {
        this.shoppingListRepository = shoppingListRepository;
        this.userRepository = userRepository;
        this.shoppingListMapper = shoppingListMapper;
    }

    private void findListExistById(Long id) {
        if(shoppingListRepository.findById(id).isEmpty()){
            throw new IdNotExistsException("Lista não encontrada");
        }
    }

    private void findListExistByDescription(String description) {
        if(shoppingListRepository.existsByDescription(description)) {
            throw new DescriptionAlreadyExistsException("Nao é possivel fazer a atualizacao pois ja existe uma lista com esse nome");
        }
    }

    private UserEntity getUserById(Long id) {
        Optional<UserEntity> user = userRepository.findById(id);
        if (user.isEmpty()) {
            throw new IdNotExistsException("Usuario nao existente");
        }
        return user.get();
    }

    @Override
    public ShoppingListDto execute(ShoppingListDto shoppingListDto) {
        findListExistById(shoppingListDto.getId());
        findListExistByDescription(shoppingListDto.getDescription());
        ShoppingListEntity shoppingListEntity =
                shoppingListRepository.save(
                        shoppingListMapper.toListEntity(shoppingListDto,
                        getUserById(shoppingListDto.getUserId())));
        return shoppingListMapper.toListDTO(shoppingListEntity);
    }
}
