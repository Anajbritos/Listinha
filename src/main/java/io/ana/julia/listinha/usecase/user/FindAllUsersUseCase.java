package io.ana.julia.listinha.usecase.user;

import io.ana.julia.listinha.data.dto.UserDto;

import java.util.List;

public interface FindAllUsersUseCase {
    List<UserDto> execute();
}
