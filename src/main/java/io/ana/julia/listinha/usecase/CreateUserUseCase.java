package io.ana.julia.listinha.usecase;

import io.ana.julia.listinha.data.dto.UserDTO;

public interface CreateUserUseCase {
    public UserDTO execute(UserDTO userDTO);
}
