package io.ana.julia.listinha.usecase;

import io.ana.julia.listinha.data.UserRepository;
import io.ana.julia.listinha.data.dto.UserDTO;
import io.ana.julia.listinha.data.entity.UserEntity;
import io.ana.julia.listinha.data.mapper.UserMapper;
import io.ana.julia.listinha.exception.IdAlreadyExistsException;
import org.springframework.stereotype.Component;

@Component
public class CreateUserUseCaseImpl implements CreateUserUseCase {
    private UserRepository userRepository;
    private UserMapper userMapper;

    public CreateUserUseCaseImpl(
            UserRepository userRepository,
            UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public void findById(Long id) {
        if(userRepository.findById(id).isPresent()) {
            throw new IdAlreadyExistsException("Usuário já cadastrado");
        }
    }

    @Override
    public UserDTO execute(UserDTO userDTO) {
        findById(userDTO.getId());
        UserEntity userEntity = userMapper.toUserEntity(userDTO);
        userRepository.save(userEntity);
        return userMapper.toUserDTO(userEntity);
    }
}
