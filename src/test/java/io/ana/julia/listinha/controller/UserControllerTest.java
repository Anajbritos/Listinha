package io.ana.julia.listinha.controller;

import io.ana.julia.listinha.data.dto.UserDto;
import io.ana.julia.listinha.service.UserServiceImpl;
import io.ana.julia.listinha.utils.AssertionData;
import io.ana.julia.listinha.utils.DataFactory;
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

    private UserServiceImpl userService;
    private UserController userController;

    @BeforeEach
    void setup() {
        userService = Mockito.mock(UserServiceImpl.class);
        userController = new UserController(userService);
    }

    @Test
    public void givenResponseUserDto_whenCreateUser_thenReturnResponseCreated() {
        when(userService.createUser(any())).thenReturn(DataFactory.userDTO());

        ResponseEntity<UserDto> responseCreatedUser =
                userController.createUser(DataFactory.userDTO());

        Assertions.assertNotNull(responseCreatedUser);
        Assertions.assertNotNull(responseCreatedUser.getBody());
        Assertions.assertEquals(responseCreatedUser.getStatusCode(), HttpStatus.CREATED);
        AssertionData.assertMapperUserDTOEqual(responseCreatedUser.getBody(), DataFactory.userDTO());
        Assertions.assertEquals(responseCreatedUser.getBody().getClass(), DataFactory.userDTO().getClass());

        verify(userService).createUser(any());
    }

    @Test
    public void givenResponseVoid_whenDeleteUser_thenReturnResponseDeleted() {
        doNothing().when(userService).deleteUser(anyLong());

        ResponseEntity<?> responseDeletedUser = userController.deleteUser(DataFactory.userDTO().getId());

        Assertions.assertNotNull(responseDeletedUser);
        Assertions.assertNull(responseDeletedUser.getBody());
        Assertions.assertEquals(responseDeletedUser.getStatusCode(), HttpStatus.NO_CONTENT);

        verify(userService).deleteUser(any());
    }

    @Test
    public void givenResponseUserDto_whenUpdateUser_thenReturnResponseUpdated() {
        when(userService.updateUser(any())).thenReturn(DataFactory.userDTO());

        ResponseEntity<UserDto> responseUpdateUser =
                userController.updateUser(DataFactory.userDTO());

        Assertions.assertNotNull(responseUpdateUser);
        Assertions.assertNotNull(responseUpdateUser.getBody());
        Assertions.assertEquals(responseUpdateUser.getStatusCode(), HttpStatus.OK);
        AssertionData.assertMapperUserDTOEqual(responseUpdateUser.getBody(), DataFactory.userDTO());
        Assertions.assertEquals(responseUpdateUser.getBody().getClass(), DataFactory.userDTO().getClass());

        verify(userService).updateUser(any());
    }

    @Test
    public void givenResponseUserDto_whenFindAllUsers_thenReturnResponseUpdated() {
        when(userService.findAllUsers()).thenReturn(
                List.of(
                        DataFactory.userDTO(),
                        DataFactory.userDTO()));

        ResponseEntity<List<UserDto>> responseFindAllUser =
                userController.findAllUsers();

        Assertions.assertNotNull(responseFindAllUser);
        Assertions.assertNotNull(responseFindAllUser.getBody());
        Assertions.assertEquals(responseFindAllUser.getStatusCode(), HttpStatus.OK);
        AssertionData.assertMapperUserDTOEqual(responseFindAllUser.getBody().get(0), DataFactory.userDTO());
        Assertions.assertEquals(responseFindAllUser.getBody().size(), 2);

        verify(userService).findAllUsers();
    }

}
