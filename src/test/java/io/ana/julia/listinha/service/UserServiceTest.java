package io.ana.julia.listinha.service;

import io.ana.julia.listinha.data.dto.UserDTO;
import io.ana.julia.listinha.usecase.*;
import io.ana.julia.listinha.utils.AssertionData;
import io.ana.julia.listinha.utils.DataFactory;
import org.apache.catalina.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    private static CreateUserUseCase createUserUseCase;
    private DeleteUserUseCase deleteUserUseCase;
    private UpdateUserUseCase updateUserUseCase;
    private FindAllUsersUseCase findAllUsersUseCase;
    private UserServiceImpl userService;

    @BeforeEach
    void setup() {
        createUserUseCase = Mockito.mock(CreateUserUseCase.class);
        deleteUserUseCase = Mockito.mock(DeleteUserUseCase.class);
        updateUserUseCase = Mockito.mock(UpdateUserUseCase.class);
        findAllUsersUseCase = Mockito.mock(FindAllUsersUseCase.class);
        userService = new UserServiceImpl(
                createUserUseCase,
                deleteUserUseCase,
                updateUserUseCase,
                findAllUsersUseCase);
    }

    @Test
    public void givenUserDto_whenCreateUser_thenReturnValidCreateUser() {
        when(createUserUseCase.execute(any())).thenReturn(DataFactory.userDTO());

        UserDTO userDTO = userService.createUser(DataFactory.userDTO());
        AssertionData.assertMapperUserDTOEqual(DataFactory.userDTO(), userDTO);;

        verify(createUserUseCase).execute(any());
    }

    @Test
    public void givenUserDtoAndLong_whenDeleteUser_thenReturnValidDeleteUser() {
       doNothing().when(deleteUserUseCase).execute(any());

       userService.deleteUser(DataFactory.userDTO().getId());

        verify(deleteUserUseCase).execute(any());
    }

    @Test
    public void givenUserDto_whenUpdateUser_thenReturnValidUpdateUser() {
        when(updateUserUseCase.execute(any())).thenReturn(DataFactory.userDTO());
        UserDTO userDTO = userService.updateUser(DataFactory.userDTO());
        AssertionData.assertMapperUserDTOEqual(DataFactory.userDTO(), userDTO);

        verify(updateUserUseCase).execute(any());
    }

    @Test
    public void givenNoAttributes_whenFindAllUsers_thenReturnValidListUsers() {
        when(findAllUsersUseCase.execute()).thenReturn(
                List.of(
                        DataFactory.userDTO(),
                        DataFactory.userDTO()));
        List<UserDTO> userDTOS = userService.findAllUsers();
        AssertionData.assertMapperUserDTOEqual(DataFactory.userDTO(), userDTOS.get(0));

        verify(findAllUsersUseCase).execute();
    }
}
