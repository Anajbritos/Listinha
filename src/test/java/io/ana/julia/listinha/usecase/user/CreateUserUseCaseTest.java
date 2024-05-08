package io.ana.julia.listinha.usecase.user;

import io.ana.julia.listinha.data.UserRepository;
import io.ana.julia.listinha.data.dto.UserDto;
import io.ana.julia.listinha.data.mapper.UserMapper;
import io.ana.julia.listinha.exception.IdAlreadyExistsException;
import io.ana.julia.listinha.usecase.user.CreateUserUseCaseImpl;
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
public class CreateUserUseCaseTest {

    private UserRepository userRepository;
    private UserMapper userMapper;
    private CreateUserUseCaseImpl createUserUseCase;

    @BeforeEach
    void setup() {
        userRepository = Mockito.mock(UserRepository.class);
        userMapper = Mockito.mock(UserMapper.class);
        createUserUseCase = new CreateUserUseCaseImpl(userRepository,userMapper);
    }

    @Test
    public void givenUserDTO_whenExecute_thenCreateUserWithSuccess() {
        when(userRepository.existsByEmail(any())).thenReturn(false);
        when(userMapper.toUserEntity(any())).thenReturn(DataFactoryUser.userEntity());
        when(userRepository.save(any())).thenReturn(DataFactoryUser.userEntity());

        UserDto userDTO = createUserUseCase.execute(DataFactoryUser.userDTO());

        verify(userRepository).existsByEmail(any());
        verify(userMapper).toUserEntity(any());
        verify(userRepository).save(any());
    }

    @Test
    public void givenUserDTO_whenExecute_thenCreateUserWithFailure() {
        when(userRepository.existsByEmail(any())).thenReturn(true);

        Assertions.assertThrows(
                IdAlreadyExistsException.class,
                ()-> createUserUseCase.execute(DataFactoryUser.userDTO())
        );
        verify(userRepository).existsByEmail(any());
    }

}
