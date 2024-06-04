package io.ana.julia.listinha.utils;

import io.ana.julia.listinha.data.dto.UserDto;
import io.ana.julia.listinha.data.entity.UserEntity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class DataFactoryUser {

    public static UserDto userDTO() {
        return new UserDto(
                1L,
                "Ana Julia",
                "Brito de Souza",
                "anajbritos@gmail.com",
                "123456789",
                true,
                LocalDateTime.of(2024,5,28,17,10, 3),
                LocalDateTime.of(2025,2,28,3,10, 3));
    }

    public static UserEntity userEntity() {
        return new UserEntity(
                1L,
                "Ana Julia",
                "Brito de Souza",
                "anajbritos@gmail.com",
                "123456789",
                true,
                LocalDateTime.of(2024,5,28,17,10, 3),
                LocalDateTime.of(2025,2,28,3,10, 3));
    }
}
