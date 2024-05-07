package io.ana.julia.listinha.usecase;

import io.ana.julia.listinha.data.UserRepository;
import io.ana.julia.listinha.data.dto.UserDTO;
import io.ana.julia.listinha.data.mapper.UserMapper;
import io.ana.julia.listinha.exception.IdAlreadyExistsException;
import io.ana.julia.listinha.exception.IdNotExistsException;
import io.ana.julia.listinha.utils.AssertionData;
import io.ana.julia.listinha.utils.DataFactory;
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
        when(userRepository.findById(any())).thenReturn(Optional.of(DataFactory.userEntity()));
        when(userMapper.toUserEntity(any())).thenReturn(DataFactory.userEntity());
        when(userRepository.save(any())).thenReturn(DataFactory.userEntity());
        when(userMapper.toUserDTO(any())).thenReturn(DataFactory.userDTO());

        UserDTO userDTO = updateUserUseCase.execute(DataFactory.userDTO());
        AssertionData.assertMapperUserDTO(userDTO, DataFactory.userEntity());

        verify(userRepository).findById(any());
        verify(userMapper).toUserEntity(any());
        verify(userRepository).save(any());
        verify(userMapper).toUserDTO(any());
    }

    @Test
    public void givenUserDTO_whenExecute_thenUpdateUserCancel() {
        when(userRepository.findById(any())).thenReturn(Optional.empty());

        Assertions.assertThrows(IdNotExistsException.class,
                () -> updateUserUseCase.execute(DataFactory.userDTO()));

        verify(userRepository).findById(any());
    }
}
