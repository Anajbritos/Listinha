package io.ana.julia.listinha.utils;

import io.ana.julia.listinha.data.dto.UserDto;
import io.ana.julia.listinha.data.entity.UserEntity;

public class DataFactoryUser {

    public static UserDto userDTO() {
        return new UserDto(
                1L,
                "Ana Julia",
                "anajbritos@gmail.com",
                "123456789");
    }

    public static UserEntity userEntity() {
        return new UserEntity(
                1L,
                "Ana Julia",
                "anajbritos@gmail.com",
                "123456789");
    }
}
