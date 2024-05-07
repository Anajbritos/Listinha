package io.ana.julia.listinha.service;

import io.ana.julia.listinha.data.dto.UserDto;
import io.ana.julia.listinha.usecase.*;
import io.ana.julia.listinha.utils.AssertionUserData;
import io.ana.julia.listinha.utils.DataFactoryUser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
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
        when(createUserUseCase.execute(any())).thenReturn(DataFactoryUser.userDTO());

        UserDto userDTO = userService.createUser(DataFactoryUser.userDTO());
        AssertionUserData.assertMapperUserDTOEqual(DataFactoryUser.userDTO(), userDTO);;

        verify(createUserUseCase).execute(any());
    }

    @Test
    public void givenUserDtoAndLong_whenDeleteUser_thenReturnValidDeleteUser() {
       doNothing().when(deleteUserUseCase).execute(any());

       userService.deleteUser(DataFactoryUser.userDTO().getId());

        verify(deleteUserUseCase).execute(any());
    }

    @Test
    public void givenUserDto_whenUpdateUser_thenReturnValidUpdateUser() {
        when(updateUserUseCase.execute(any())).thenReturn(DataFactoryUser.userDTO());
        UserDto userDTO = userService.updateUser(DataFactoryUser.userDTO());
        AssertionUserData.assertMapperUserDTOEqual(DataFactoryUser.userDTO(), userDTO);

        verify(updateUserUseCase).execute(any());
    }

    @Test
    public void givenNoAttributes_whenFindAllUsers_thenReturnValidListUsers() {
        when(findAllUsersUseCase.execute()).thenReturn(
                List.of(
                        DataFactoryUser.userDTO(),
                        DataFactoryUser.userDTO()));
        List<UserDto> userDTOS = userService.findAllUsers();
        AssertionUserData.assertMapperUserDTOEqual(DataFactoryUser.userDTO(), userDTOS.get(0));

        verify(findAllUsersUseCase).execute();
    }
}
