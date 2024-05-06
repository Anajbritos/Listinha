package io.ana.julia.listinha.utils;

import io.ana.julia.listinha.data.userDTO.UserDTO;
import io.ana.julia.listinha.data.userEntity.UserEntity;
import org.junit.jupiter.api.Assertions;

public class AssertionData {
    public static void assertMapperUser(UserDTO userDTO, UserEntity userEntity) {
        Assertions.assertEquals(userDTO.getId(), userEntity.getId());
        Assertions.assertEquals(userDTO.getName(), userEntity.getName());
        Assertions.assertEquals(userDTO.getEmail(), userEntity.getEmail());
        Assertions.assertEquals(userDTO.getPassword(), userEntity.getPassword());
    }
}
