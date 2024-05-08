package io.ana.julia.listinha.usecase.user;

import io.ana.julia.listinha.data.dto.UserDto;

public interface CreateUserUseCase {
    UserDto execute(UserDto userDTO);
}
