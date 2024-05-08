package io.ana.julia.listinha.controller;

import io.ana.julia.listinha.data.dto.UserDto;
import io.ana.julia.listinha.service.UserService;
import io.ana.julia.listinha.utils.AssertionUserData;
import io.ana.julia.listinha.utils.DataFactoryUser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserControllerTest {

    private UserService userService;
    private UserController userController;

    @BeforeEach
    void setup() {
        userService = Mockito.mock(UserService.class);
        userController = new UserController(userService);
    }

    @Test
    public void givenResponseUserDto_whenCreateUser_thenReturnResponseCreated() {
        when(userService.createUser(any())).thenReturn(DataFactoryUser.userDTO());

        ResponseEntity<UserDto> responseCreatedUser =
                userController.createUser(DataFactoryUser.userDTO());

        Assertions.assertNotNull(responseCreatedUser);
        Assertions.assertNotNull(responseCreatedUser.getBody());
        Assertions.assertEquals(responseCreatedUser.getStatusCode(), HttpStatus.CREATED);
        AssertionUserData.assertMapperUserDTOEqual(responseCreatedUser.getBody(), DataFactoryUser.userDTO());
        Assertions.assertEquals(responseCreatedUser.getBody().getClass(), DataFactoryUser.userDTO().getClass());

        verify(userService).createUser(any());
    }

    @Test
    public void givenResponseVoid_whenDeleteUser_thenReturnResponseDeleted() {
        doNothing().when(userService).deleteUser(anyLong());

        ResponseEntity<?> responseDeletedUser = userController.deleteUser(DataFactoryUser.userDTO().getId());

        Assertions.assertNotNull(responseDeletedUser);
        Assertions.assertNull(responseDeletedUser.getBody());
        Assertions.assertEquals(responseDeletedUser.getStatusCode(), HttpStatus.NO_CONTENT);

        verify(userService).deleteUser(any());
    }

    @Test
    public void givenResponseUserDto_whenUpdateUser_thenReturnResponseUpdated() {
        when(userService.updateUser(any())).thenReturn(DataFactoryUser.userDTO());

        ResponseEntity<UserDto> responseUpdateUser =
                userController.updateUser(DataFactoryUser.userDTO());

        Assertions.assertNotNull(responseUpdateUser);
        Assertions.assertNotNull(responseUpdateUser.getBody());
        Assertions.assertEquals(responseUpdateUser.getStatusCode(), HttpStatus.OK);
        AssertionUserData.assertMapperUserDTOEqual(responseUpdateUser.getBody(), DataFactoryUser.userDTO());
        Assertions.assertEquals(responseUpdateUser.getBody().getClass(), DataFactoryUser.userDTO().getClass());

        verify(userService).updateUser(any());
    }

    @Test
    public void givenResponseUserDto_whenFindAllUsers_thenReturnResponseUpdated() {
        when(userService.findAllUsers()).thenReturn(
                List.of(
                        DataFactoryUser.userDTO(),
                        DataFactoryUser.userDTO()));

        ResponseEntity<List<UserDto>> responseFindAllUser =
                userController.findAllUsers();

        Assertions.assertNotNull(responseFindAllUser);
        Assertions.assertNotNull(responseFindAllUser.getBody());
        Assertions.assertEquals(responseFindAllUser.getStatusCode(), HttpStatus.OK);
        AssertionUserData.assertMapperUserDTOEqual(responseFindAllUser.getBody().get(0), DataFactoryUser.userDTO());
        Assertions.assertEquals(responseFindAllUser.getBody().size(), 2);
        Assertions.assertEquals(responseFindAllUser.getBody().get(0).getClass(), DataFactoryUser.userDTO().getClass());

        verify(userService).findAllUsers();
    }

}
