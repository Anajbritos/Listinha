package io.ana.julia.listinha.utils;

import io.ana.julia.listinha.data.dto.UserDto;
import io.ana.julia.listinha.data.entity.UserEntity;
import org.junit.jupiter.api.Assertions;

public class AssertionUserData {
    public static void assertMapperUserDTO(UserDto userDTO, UserEntity userEntity) {
        Assertions.assertEquals(userDTO.getId(), userEntity.getId());
        Assertions.assertEquals(userDTO.getName(), userEntity.getName());
        Assertions.assertEquals(userDTO.getEmail(), userEntity.getEmail());
        Assertions.assertEquals(userDTO.getPassword(), userEntity.getPassword());
    }

    public static void assertMapperUserEntity(UserEntity userEntity , UserDto userDTO) {
        Assertions.assertEquals(userEntity.getId(), userDTO.getId());
        Assertions.assertEquals(userEntity.getName(), userDTO.getName());
        Assertions.assertEquals(userEntity.getEmail(), userDTO.getEmail());
        Assertions.assertEquals(userEntity.getPassword(), userDTO.getPassword());
    }

    public static void assertMapperUserDTOEqual(UserDto userDtoA , UserDto userDtoB) {
        Assertions.assertEquals(userDtoA.getId(), userDtoB.getId());
        Assertions.assertEquals(userDtoA.getName(), userDtoB.getName());
        Assertions.assertEquals(userDtoA.getEmail(), userDtoB.getEmail());
        Assertions.assertEquals(userDtoA.getPassword(), userDtoB.getPassword());
    }
}
