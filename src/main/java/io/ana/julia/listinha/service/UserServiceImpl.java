package io.ana.julia.listinha.service;

import io.ana.julia.listinha.data.dto.UserDTO;
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
    public UserDTO createUser(UserDTO userDTO) {
        return createUserUseCase.execute(userDTO);
    }

    @Override
    public void deleteUser(UserDTO userDTO, Long id) {
        deleteUserUseCase.execute(userDTO,id);
    }

    @Override
    public UserDTO updateUser(UserDTO userDTO) {
        return updateUserUseCase.execute(userDTO);
    }

    @Override
    public List<UserDTO> findAllUsers() {
        return findAllUsersUseCase.execute();
    }
}
