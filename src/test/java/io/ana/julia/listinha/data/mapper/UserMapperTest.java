package io.ana.julia.listinha.data.mapper;

import io.ana.julia.listinha.data.dto.UserDTO;
import io.ana.julia.listinha.data.entity.UserEntity;
import io.ana.julia.listinha.utils.AssertionData;
import io.ana.julia.listinha.utils.DataFactory;
import org.junit.jupiter.api.Test;

public class UserMapperTest {
    private final UserMapper userMapper = new UserMapper();

    @Test
    public void givenUserDTO_whenMapper_thenValueIsEqual() {
        UserDTO userDTO = DataFactory.userDTO();
        UserEntity userEntity = userMapper.toUserEntity(userDTO);
        AssertionData.assertMapperUserDTO(userDTO,userEntity);
    }

    @Test
    public void givenUserEntity_whenMapper_thenValueIsEqual() {
        UserEntity userEntity = DataFactory.userEntity();
        UserDTO userDTO = userMapper.toUserDTO(userEntity);
        AssertionData.assertMapperUserEntity(userEntity,userDTO);
    }
}
