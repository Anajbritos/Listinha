package io.ana.julia.listinha.usecase.user;

import io.ana.julia.listinha.data.dto.UserDto;

public interface UpdateUserUseCase {
    UserDto execute(UserDto userDTO);
}
