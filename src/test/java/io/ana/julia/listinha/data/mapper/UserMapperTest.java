package io.ana.julia.listinha.data.mapper;

import io.ana.julia.listinha.data.dto.UserDto;
import io.ana.julia.listinha.data.entity.UserEntity;
import io.ana.julia.listinha.utils.AssertionUserData;
import io.ana.julia.listinha.utils.DataFactoryUser;
import org.junit.jupiter.api.Test;

public class UserMapperTest {
    private final UserMapper userMapper = new UserMapper();

    @Test
    public void givenUserDTO_whenMapper_thenValueIsEqual() {
        UserDto userDTO = DataFactoryUser.userDTO();
        UserEntity userEntity = userMapper.toUserEntity(userDTO);
        AssertionUserData.assertMapperUserDTO(userDTO,userEntity);
    }

    @Test
    public void givenUserEntity_whenMapper_thenValueIsEqual() {
        UserEntity userEntity = DataFactoryUser.userEntity();
        UserDto userDTO = userMapper.toUserDTO(userEntity);
        AssertionUserData.assertMapperUserEntity(userEntity,userDTO);
    }
}
