package io.ana.julia.listinha.service;

import io.ana.julia.listinha.data.dto.UserDTO;
import io.ana.julia.listinha.usecase.CreateUserUseCase;
import io.ana.julia.listinha.usecase.DeleteUserUseCase;
import io.ana.julia.listinha.usecase.FindAllUsersUseCase;
import io.ana.julia.listinha.usecase.UpdateUserUseCase;

import java.util.List;

public interface UserService {

    public UserDTO createUser(UserDTO userDTO);
    public void deleteUser(Long id);
    public UserDTO updateUser(UserDTO userDTO);
    public List<UserDTO> findAllUsers();
}
