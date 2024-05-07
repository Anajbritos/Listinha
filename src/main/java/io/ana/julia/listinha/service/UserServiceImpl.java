package io.ana.julia.listinha.service;

import io.ana.julia.listinha.usecase.*;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService{

    public CreateUserUseCaseImpl createUserUseCase;
    public DeleteUserUseCaseImpl deleteUserUseCase;
    public UpdateUserUseCaseImpl updateUserUseCase;
    public FindAllUsersUseCaseImpl findAllUsersUseCase;

    public UserServiceImpl(CreateUserUseCaseImpl createUserUseCase,
                           DeleteUserUseCaseImpl deleteUserUseCase,
                           UpdateUserUseCaseImpl updateUserUseCase,
                           FindAllUsersUseCaseImpl findAllUsersUseCase) {
        this.createUserUseCase = createUserUseCase;
        this.deleteUserUseCase = deleteUserUseCase;
        this.updateUserUseCase = updateUserUseCase;
        this.findAllUsersUseCase = findAllUsersUseCase;
    }


    @Override
    public CreateUserUseCase createUserUseCase() {
        return null;
    }

    @Override
    public DeleteUserUseCase deleteUserUseCase() {
        return null;
    }

    @Override
    public UpdateUserUseCase updateUserUseCase() {
        return null;
    }

    @Override
    public FindAllUsersUseCase findAllUsersUseCase() {
        return null;
    }
}
