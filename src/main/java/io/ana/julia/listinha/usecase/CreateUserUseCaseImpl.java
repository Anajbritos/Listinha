package io.ana.julia.listinha.usecase;

import io.ana.julia.listinha.data.UserRepository;
import io.ana.julia.listinha.data.dto.UserDTO;
import io.ana.julia.listinha.data.entity.UserEntity;
import io.ana.julia.listinha.data.mapper.UserMapper;
import io.ana.julia.listinha.exception.IdAlreadyExistsException;
import org.springframework.stereotype.Component;

@Component
public class CreateUserUseCaseImpl implements CreateUserUseCase {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public CreateUserUseCaseImpl(
            UserRepository userRepository,
            UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public void findUserExistsById(Long id) {
        if(userRepository.findById(id).isPresent()) {
            throw new IdAlreadyExistsException("Usuário já cadastrado");
        }
    }

    @Override
    public UserDTO execute(UserDTO userDTO) {
        findUserExistsById(userDTO.getId());
        UserEntity userEntity = userMapper.toUserEntity(userDTO);
        userRepository.save(userEntity);
        return userMapper.toUserDTO(userEntity);
    }
}
