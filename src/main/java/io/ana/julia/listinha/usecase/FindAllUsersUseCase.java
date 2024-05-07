package io.ana.julia.listinha.usecase;

import io.ana.julia.listinha.data.dto.UserDTO;

import java.util.List;

public interface FindAllUsersUseCase {
    public List<UserDTO> execute();
}
