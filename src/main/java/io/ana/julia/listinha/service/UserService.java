package io.ana.julia.listinha.service;

import io.ana.julia.listinha.usecase.CreateUserUseCase;
import io.ana.julia.listinha.usecase.DeleteUserUseCase;
import io.ana.julia.listinha.usecase.FindAllUsersUseCase;
import io.ana.julia.listinha.usecase.UpdateUserUseCase;

public interface UserService {

    public CreateUserUseCase createUserUseCase();
    public DeleteUserUseCase deleteUserUseCase();
    public UpdateUserUseCase updateUserUseCase();
    public FindAllUsersUseCase findAllUsersUseCase();
}
