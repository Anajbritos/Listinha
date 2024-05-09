package io.ana.julia.listinha.usecase.item;

import io.ana.julia.listinha.data.ShoppingListRepository;
import io.ana.julia.listinha.data.UserRepository;
import io.ana.julia.listinha.data.dto.ShoppingListDto;
import io.ana.julia.listinha.data.mapper.ShoppingListMapper;
import io.ana.julia.listinha.exception.IdNotExistsException;
import io.ana.julia.listinha.usecase.user.GetListByUserUseCaseImpl;
import io.ana.julia.listinha.utils.AssertionShoppingListData;
import io.ana.julia.listinha.utils.DataFactoryShoppingList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class GetListByUserUseCaseTest {

    private static UserRepository userRepository;
    private static ShoppingListRepository shoppingListRepository;
    private static ShoppingListMapper shoppingListMapper;
    private static GetListByUserUseCaseImpl getListByUserUseCase;

    @BeforeEach
    void setup() {
        userRepository = Mockito.mock(UserRepository.class);
        shoppingListRepository = Mockito.mock(ShoppingListRepository.class);
        shoppingListMapper = Mockito.mock(ShoppingListMapper.class);
        getListByUserUseCase = new GetListByUserUseCaseImpl(
                userRepository,
                shoppingListRepository,
                shoppingListMapper);
    }

    @Test
    public void givenUserId_whenExecute_thenGetListByUserSuccess() {
        when(userRepository.existsById(any())).thenReturn(true);
        when(shoppingListRepository.findAllByUserId(any())).thenReturn(
                List.of(DataFactoryShoppingList.listEntity(),
                        DataFactoryShoppingList.listEntity()));
        when(shoppingListMapper.toListDTO(any())).thenReturn(DataFactoryShoppingList.listDto());

        List<ShoppingListDto> shoppingListDtos = getListByUserUseCase.execute(
                DataFactoryShoppingList.listDto().getId());

        AssertionShoppingListData.assertMapperListEquals(
                shoppingListDtos.get(1),
                DataFactoryShoppingList.listDto());
        Assertions.assertEquals(shoppingListDtos.size(),2);
        Assertions.assertNotNull(shoppingListDtos);

        verify(userRepository).existsById(any());
        verify(shoppingListRepository).findAllByUserId(any());
        verify(shoppingListMapper, times(2)).toListDTO(any());
    }

    @Test
    public void givenUserId_whenExecute_thenGetListByUserEmpty() {
        when(userRepository.existsById(any())).thenReturn(true);
        when(shoppingListRepository.findAllByUserId(any())).thenReturn(
                List.of());

        List<ShoppingListDto> shoppingListDtos = getListByUserUseCase.execute(
                DataFactoryShoppingList.listDto().getId());

        Assertions.assertNotNull(shoppingListDtos);
        Assertions.assertEquals(shoppingListDtos.size(),0);

        verify(userRepository).existsById(any());
        verify(shoppingListRepository).findAllByUserId(any());
    }

    @Test
    public void givenUserId_whenExecute_thenGetListByUserFailure() {
        when(userRepository.existsById(any())).thenReturn(false);

        Assertions.assertThrows(
                IdNotExistsException.class,
                ()-> getListByUserUseCase.execute(DataFactoryShoppingList.listEntity().getId()));

        verify(userRepository).existsById(any());
    }
}
