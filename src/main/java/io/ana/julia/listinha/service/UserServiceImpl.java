package io.ana.julia.listinha.service;

import io.ana.julia.listinha.data.dto.UserDto;
import io.ana.julia.listinha.usecase.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserServiceImpl implements UserService{

    public CreateUserUseCase createUserUseCase;
    public DeleteUserUseCase deleteUserUseCase;
    public UpdateUserUseCase updateUserUseCase;
    public FindAllUsersUseCase findAllUsersUseCase;

    @Autowired
    public UserServiceImpl(CreateUserUseCase createUserUseCase,
                           DeleteUserUseCase deleteUserUseCase,
                           UpdateUserUseCase updateUserUseCase,
                           FindAllUsersUseCase findAllUsersUseCase) {
        this.createUserUseCase = createUserUseCase;
        this.deleteUserUseCase = deleteUserUseCase;
        this.updateUserUseCase = updateUserUseCase;
        this.findAllUsersUseCase = findAllUsersUseCase;
    }


    @Override
    public UserDto createUser(UserDto userDTO) {
        return createUserUseCase.execute(userDTO);
    }

    @Override
    public void deleteUser(Long id) {
        deleteUserUseCase.execute(id);
    }

    @Override
    public UserDto updateUser(UserDto userDTO) {
        return updateUserUseCase.execute(userDTO);
    }

    @Override
    public List<UserDto> findAllUsers() {
        return findAllUsersUseCase.execute();
    }
}
