package io.ana.julia.listinha.usecase;

import io.ana.julia.listinha.data.dto.UserDTO;

public interface DeleteUserUseCase {
    public void execute(Long id);
}
