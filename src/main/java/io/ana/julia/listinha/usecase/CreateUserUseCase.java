package io.ana.julia.listinha.usecase;

import io.ana.julia.listinha.data.dto.UserDto;

public interface CreateUserUseCase {
    public UserDto execute(UserDto userDTO);
}
