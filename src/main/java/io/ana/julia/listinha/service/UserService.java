package io.ana.julia.listinha.service;

import io.ana.julia.listinha.data.dto.UserDto;

import java.util.List;

public interface UserService {

    public UserDto createUser(UserDto userDTO);
    public void deleteUser(Long id);
    public UserDto updateUser(UserDto userDTO);
    public List<UserDto> findAllUsers();
}
