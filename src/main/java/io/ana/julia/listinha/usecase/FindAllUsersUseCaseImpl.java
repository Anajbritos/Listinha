package io.ana.julia.listinha.usecase;

import io.ana.julia.listinha.data.UserRepository;
import io.ana.julia.listinha.data.dto.UserDTO;
import io.ana.julia.listinha.data.entity.UserEntity;
import io.ana.julia.listinha.data.mapper.UserMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindAllUsersUseCaseImpl implements FindAllUsersUseCase {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public FindAllUsersUseCaseImpl(
            UserRepository userRepository,
            UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public List<UserDTO> execute() {
        return userRepository.
                findAll()
                .stream().
                map(userEntity -> userMapper.toUserDTO(userEntity))
                .collect(Collectors.toList());
    }
}
