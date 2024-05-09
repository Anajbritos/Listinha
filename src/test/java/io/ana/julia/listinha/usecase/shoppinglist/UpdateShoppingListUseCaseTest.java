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
public class UpdateShoppingListUseCaseTest {

    private ShoppingListRepository shoppingListRepository;
    private UserRepository userRepository;
    private ShoppingListMapper shoppingListMapper;
    private UpdateShoppingListUseCaseImpl updateListUseCase;

    @BeforeEach
    void setup() {
        shoppingListRepository = Mockito.mock(ShoppingListRepository.class);
        userRepository = Mockito.mock(UserRepository.class);
        shoppingListMapper = Mockito.mock(ShoppingListMapper.class);
        updateListUseCase = new UpdateShoppingListUseCaseImpl(
                shoppingListRepository,
                userRepository,
                shoppingListMapper);
    }

    @Test
    public void givenListDTO_whenExecute_thenUpdateListWithSuccess() {
        when(shoppingListRepository.findById(any())).thenReturn(Optional.of(DataFactoryShoppingList.listEntity()));
        when(shoppingListRepository.existsByDescription(any())).thenReturn(false);
        when(userRepository.findById(any())).thenReturn(Optional.of(DataFactoryShoppingList.listEntity().getUser()));
        when(shoppingListRepository.save(any())).thenReturn(DataFactoryShoppingList.listEntity());
        when(shoppingListMapper.toListEntity(any(),any())).thenReturn(DataFactoryShoppingList.listEntity());
        when(shoppingListMapper.toListDTO(any())).thenReturn(DataFactoryShoppingList.listDto());

        ShoppingListDto shoppingListDto = updateListUseCase.execute(DataFactoryShoppingList.listDto());
        AssertionShoppingListData.assertMapperListEquals(shoppingListDto, DataFactoryShoppingList.listDto());

        verify(shoppingListRepository).findById(any());
        verify(userRepository).findById(any());
        verify(shoppingListRepository).existsByDescription(any());
        verify(shoppingListRepository).save(any());
        verify(shoppingListMapper).toListEntity(any(),any());
        verify(shoppingListMapper).toListDTO(any());
    }

    @Test
    public void givenListDTO_whenExecute_thenUpdateListFailureWithId() {
        when(shoppingListRepository.findById(any())).thenReturn(Optional.empty());

        Assertions.assertThrows(
                IdNotExistsException.class,
                () -> updateListUseCase.execute(DataFactoryShoppingList.listDto()));

        verify(shoppingListRepository).findById(any());
    }

    @Test
    public void givenListDTO_whenExecute_thenUpdateListFailureWithDescription() {
        when(shoppingListRepository.findById(any())).thenReturn(Optional.of(DataFactoryShoppingList.listEntity()));
        when(shoppingListRepository.existsByDescription(any())).thenReturn(true);

        Assertions.assertThrows(
                DescriptionAlreadyExistsException.class,
                () -> updateListUseCase.execute(DataFactoryShoppingList.listDto()));

        verify(shoppingListRepository).findById(any());
        verify(shoppingListRepository).existsByDescription(any());
    }

    @Test
    public void givenListDTO_whenExecute_thenUpdateListFailureWithUser() {
        when(shoppingListRepository.findById(any())).thenReturn(Optional.of(DataFactoryShoppingList.listEntity()));
        when(shoppingListRepository.existsByDescription(any())).thenReturn(false);
        when(userRepository.findById(any())).thenReturn(Optional.empty());

        Assertions.assertThrows(
                IdNotExistsException.class,
                () -> updateListUseCase.execute(DataFactoryShoppingList.listDto()));

        verify(shoppingListRepository).findById(any());
        verify(shoppingListRepository).existsByDescription(any());
    }
}
