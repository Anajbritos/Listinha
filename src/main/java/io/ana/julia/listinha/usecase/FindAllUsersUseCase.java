package io.ana.julia.listinha.usecase;

import io.ana.julia.listinha.data.dto.UserDto;

import java.util.List;

public interface FindAllUsersUseCase {
    public List<UserDto> execute();
}
