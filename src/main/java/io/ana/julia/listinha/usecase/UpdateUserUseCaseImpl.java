package io.ana.julia.listinha.usecase;

import io.ana.julia.listinha.data.UserRepository;
import io.ana.julia.listinha.data.dto.UserDTO;
import io.ana.julia.listinha.data.entity.UserEntity;
import io.ana.julia.listinha.data.mapper.UserMapper;
import io.ana.julia.listinha.exception.IdAlreadyExistsException;
import io.ana.julia.listinha.exception.IdNotExistsException;
import org.springframework.stereotype.Component;

@Component
public class UpdateUserUseCaseImpl implements UpdateUserUseCase{

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UpdateUserUseCaseImpl(
            UserRepository userRepository,
            UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public void findUserExistsByEmail(Long id) {
        if(!userRepository.existsById(id)){
            throw new IdNotExistsException("Usuário não cadastrado");
        }
    }

    @Override
    public UserDTO execute(UserDTO userDTO) {
        findUserExistsByEmail(userDTO.getId());
        UserEntity userEntity = userMapper.toUserEntity(userDTO);
        userRepository.save(userEntity);
        return userMapper.toUserDTO(userEntity);
    }
}
