package io.ana.julia.listinha.usecase;

import io.ana.julia.listinha.data.UserRepository;
import io.ana.julia.listinha.data.dto.UserDTO;
import io.ana.julia.listinha.data.entity.UserEntity;
import io.ana.julia.listinha.data.mapper.UserMapper;
import io.ana.julia.listinha.exception.IdAlreadyExistsException;
import io.ana.julia.listinha.exception.IdNotExistsException;
import org.springframework.stereotype.Component;

@Component
public class DeleteUserUseCaseImpl implements DeleteUserUseCase{

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public DeleteUserUseCaseImpl(
            UserRepository userRepository,
            UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public void findUserExistsById(Long id) {
        if(userRepository.findById(id).isEmpty()) {
            throw new IdNotExistsException("Usuário nao existente");
        }
    }

    @Override
    public void execute(UserDTO userDTO, Long id) {
        findUserExistsById(id);
        UserEntity userEntity = userMapper.toUserEntity(userDTO);
        userRepository.delete(userEntity);
    }
}
