package io.ana.julia.listinha.utils;

import io.ana.julia.listinha.data.dto.UserDTO;
import io.ana.julia.listinha.data.entity.UserEntity;
import org.junit.jupiter.api.Assertions;

public class AssertionData {
    public static void assertMapperUserDTO(UserDTO userDTO, UserEntity userEntity) {
        Assertions.assertEquals(userDTO.getId(), userEntity.getId());
        Assertions.assertEquals(userDTO.getName(), userEntity.getName());
        Assertions.assertEquals(userDTO.getEmail(), userEntity.getEmail());
        Assertions.assertEquals(userDTO.getPassword(), userEntity.getPassword());
    }

    public static void assertMapperUserEntity(UserEntity userEntity , UserDTO userDTO) {
        Assertions.assertEquals(userEntity.getId(), userDTO.getId());
        Assertions.assertEquals(userEntity.getName(), userDTO.getName());
        Assertions.assertEquals(userEntity.getEmail(), userDTO.getEmail());
        Assertions.assertEquals(userEntity.getPassword(), userDTO.getPassword());
    }
}
