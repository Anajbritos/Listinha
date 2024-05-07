package io.ana.julia.listinha.usecase;

import io.ana.julia.listinha.data.dto.UserDTO;

public interface UpdateUserUseCase {
    public UserDTO execute(UserDTO userDTO);
}
