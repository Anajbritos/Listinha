package io.ana.julia.listinha.usecase.shoppinglist;

import io.ana.julia.listinha.data.ShoppingListRepository;
import io.ana.julia.listinha.data.UserRepository;
import io.ana.julia.listinha.data.dto.ShoppingListDto;
import io.ana.julia.listinha.data.mapper.ShoppingListMapper;
import io.ana.julia.listinha.exception.DescriptionAlreadyExistsException;
import io.ana.julia.listinha.exception.IdNotExistsException;
import io.ana.julia.listinha.utils.AssertionShoppingListData;
import io.ana.julia.listinha.utils.DataFactoryShoppingList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CreateShoppingListUseCaseTest {

    private ShoppingListRepository shoppingListRepository;
    private UserRepository userRepository;
    private ShoppingListMapper shoppingListMapper;
    private CreateShoppingListUseCaseImpl createShoppingListUseCase;

    @BeforeEach
    void setup() {
        shoppingListRepository = Mockito.mock(ShoppingListRepository.class);
        userRepository = Mockito.mock(UserRepository.class);
        shoppingListMapper = Mockito.mock(ShoppingListMapper.class);
        createShoppingListUseCase = new CreateShoppingListUseCaseImpl(
                shoppingListRepository,
                userRepository,
                shoppingListMapper);
    }

    @Test
    public void givenListDTO_whenExecute_thenCreateListWithSuccess() {
        when(shoppingListRepository.existsByDescriptionIgnoreCaseAndId(any(),any())).thenReturn(false);
        when(userRepository.findById(any())).thenReturn(Optional.of(DataFactoryShoppingList.listEntity().getUser()));
        when(shoppingListMapper.toListEntity(any(),any())).thenReturn(DataFactoryShoppingList.listEntity());
        when(shoppingListRepository.save(any())).thenReturn(DataFactoryShoppingList.listEntity());
        when(shoppingListMapper.toListDTO(any())).thenReturn(DataFactoryShoppingList.listDto());

        ShoppingListDto shoppingListDto =
                createShoppingListUseCase.execute(
                        DataFactoryShoppingList.listDto());
        AssertionShoppingListData.assertMapperListEquals(shoppingListDto, DataFactoryShoppingList.listDto());

        verify(shoppingListRepository).existsByDescriptionIgnoreCaseAndId(any(),any());
        verify(userRepository).findById(any());
        verify(shoppingListMapper).toListEntity(any(),any());
        verify(shoppingListRepository).save(any());
        verify(shoppingListMapper).toListDTO(any());
    }

    @Test
    public void givenListDTO_whenExecute_thenCreateListWithFailure() {
        when(shoppingListRepository.existsByDescriptionIgnoreCaseAndId(any(),any())).thenReturn(true);

        Assertions.assertThrows(
                DescriptionAlreadyExistsException.class,
                ()-> createShoppingListUseCase
                        .execute(DataFactoryShoppingList.listDto()));

        verify(shoppingListRepository).existsByDescriptionIgnoreCaseAndId(any(),any());
    }

    @Test
    public void givenListDTO_whenExecute_thenCreateListWithIdFailure() {
        when(shoppingListRepository.existsByDescriptionIgnoreCaseAndId(any(),any())).thenReturn(false);
        when(userRepository.findById(any())).thenReturn(Optional.empty());

        Assertions.assertThrows(
                IdNotExistsException.class,
                ()-> createShoppingListUseCase
                        .execute(DataFactoryShoppingList.listDto()));

        verify(shoppingListRepository).existsByDescriptionIgnoreCaseAndId(any(),any());
    }
}
