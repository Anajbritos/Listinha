package io.ana.julia.listinha.usecase.user;

import io.ana.julia.listinha.data.UserRepository;
import io.ana.julia.listinha.data.dto.UserDto;
import io.ana.julia.listinha.data.mapper.UserMapper;
import io.ana.julia.listinha.exception.IdNotExistsException;
import io.ana.julia.listinha.usecase.user.UpdateUserUseCaseImpl;
import io.ana.julia.listinha.utils.AssertionUserData;
import io.ana.julia.listinha.utils.DataFactoryUser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UpdateUserUseCaseTest {

    private static UserRepository userRepository;
    private static UserMapper userMapper;
    private static UpdateUserUseCaseImpl updateUserUseCase;

    @BeforeEach
    void setup() {
        userRepository = Mockito.mock(UserRepository.class);
        userMapper = Mockito.mock(UserMapper.class);
        updateUserUseCase = new UpdateUserUseCaseImpl(userRepository, userMapper);
    }

    @Test
    public void givenUserDTO_whenExecute_thenUpdateUserWithSuccess() {
        when(userRepository.existsById(any())).thenReturn(true);
        when(userMapper.toUserEntity(any())).thenReturn(DataFactoryUser.userEntity());
        when(userRepository.save(any())).thenReturn(DataFactoryUser.userEntity());
        when(userMapper.toUserDTO(any())).thenReturn(DataFactoryUser.userDTO());

        UserDto userDTO = updateUserUseCase.execute(DataFactoryUser.userDTO());
        AssertionUserData.assertMapperUserDTO(userDTO, DataFactoryUser.userEntity());

        verify(userRepository).existsById(any());
        verify(userMapper).toUserEntity(any());
        verify(userRepository).save(any());
        verify(userMapper).toUserDTO(any());
    }

    @Test
    public void givenUserDTO_whenExecute_thenUpdateUserCancel() {
        when(userRepository.existsById(any())).thenReturn(false);

        Assertions.assertThrows(IdNotExistsException.class,
                () -> updateUserUseCase.execute(DataFactoryUser.userDTO()));

        verify(userRepository).existsById(any());
    }
}
