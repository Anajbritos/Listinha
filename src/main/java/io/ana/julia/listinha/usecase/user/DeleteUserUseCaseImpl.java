package io.ana.julia.listinha.usecase.user;

import io.ana.julia.listinha.data.UserRepository;
import io.ana.julia.listinha.data.mapper.UserMapper;
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
    public void execute(Long id) {
        findUserExistsById(id);
        userRepository.deleteById(id);
    }
}
