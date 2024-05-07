package io.ana.julia.listinha.usecase;

import io.ana.julia.listinha.data.UserRepository;
import io.ana.julia.listinha.data.dto.UserDto;
import io.ana.julia.listinha.data.mapper.UserMapper;
import io.ana.julia.listinha.utils.AssertionUserData;
import io.ana.julia.listinha.utils.DataFactoryUser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class FindAllUserUseCaseTest {

    private static UserRepository userRepository;
    private static UserMapper userMapper;
    private static FindAllUsersUseCaseImpl findAllUsersUseCase;

    @BeforeEach
    void setup() {
        userRepository = Mockito.mock(UserRepository.class);
        userMapper = Mockito.mock(UserMapper.class);
        findAllUsersUseCase = new FindAllUsersUseCaseImpl(userRepository, userMapper) {
        };
    }

    @Test
    public void givenNoAttributes_whenExecute_thenFindAllUsers() {
        when(userRepository.findAll()).thenReturn(
                List.of(
                        DataFactoryUser.userEntity(),
                        DataFactoryUser.userEntity()));

        when(userMapper.toUserDTO(any())).thenReturn(DataFactoryUser.userDTO());
        List<UserDto> userDTOS = findAllUsersUseCase.execute();

        Assertions.assertEquals(2,userDTOS.size());
        UserDto userDTO = userDTOS.get(0);
        AssertionUserData.assertMapperUserDTOEqual(userDTO, DataFactoryUser.userDTO());

        verify(userRepository).findAll();
        verify(userMapper, times(2)).toUserDTO(any());
    }

    @Test
    public void givenNoAttributes_whenExecute_thenFindAllUsersEmpty() {
        when(userRepository.findAll()).thenReturn(List.of());
        List<UserDto> userDTOS = findAllUsersUseCase.execute();
        Assertions.assertEquals(0,userDTOS.size());

        verify(userRepository).findAll();
        verify(userMapper, never()).toUserDTO(any());
    }

}
