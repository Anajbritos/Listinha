package io.ana.julia.listinha.usecase;

import io.ana.julia.listinha.data.UserRepository;
import io.ana.julia.listinha.data.mapper.UserMapper;
import io.ana.julia.listinha.exception.IdNotExistsException;
import io.ana.julia.listinha.usecase.user.DeleteUserUseCaseImpl;
import io.ana.julia.listinha.utils.DataFactoryUser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class DeleteUserUseCaseTest {

    private static UserRepository userRepository;
    private static UserMapper userMapper;
    private static DeleteUserUseCaseImpl deleteUserUseCase;

    @BeforeEach
    void setup() {
        userRepository = Mockito.mock(UserRepository.class);
        userMapper = Mockito.mock(UserMapper.class);
        deleteUserUseCase = new DeleteUserUseCaseImpl(userRepository, userMapper);
    }

    @Test
    public void givenUserDtoAndLong_whenExecute_thenDeleteUserWithSuccess() {
        when(userRepository.findById(any())).thenReturn(Optional.of(DataFactoryUser.userEntity()));
        doNothing().when(userRepository).deleteById(any());
        deleteUserUseCase.execute(DataFactoryUser.userDTO().getId());

        verify(userRepository).findById(any());
        verify(userRepository).deleteById(any());
    }

    @Test
    public void givenUserDtoAndLong_whenExecute_thenDeleteUserWithFailure() {
        when(userRepository.findById(any())).thenReturn(Optional.empty());

        Assertions.assertThrows(IdNotExistsException.class,
                () -> deleteUserUseCase.execute(DataFactoryUser.userEntity().getId()));

        verify(userRepository).findById(any());
    }
}
