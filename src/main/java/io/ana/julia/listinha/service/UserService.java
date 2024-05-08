package io.ana.julia.listinha.service;

import io.ana.julia.listinha.data.dto.UserDto;

import java.util.List;

public interface UserService {

    UserDto createUser(UserDto userDTO);
    void deleteUser(Long id);
    UserDto updateUser(UserDto userDTO);
    List<UserDto> findAllUsers();
}
