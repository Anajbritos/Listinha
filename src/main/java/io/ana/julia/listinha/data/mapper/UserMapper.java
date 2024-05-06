package io.ana.julia.listinha.data.mapper;

import io.ana.julia.listinha.data.dto.UserDTO;
import io.ana.julia.listinha.data.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserDTO toUserDTO(UserEntity userEntity) {
        return new UserDTO(
                userEntity.getId(),
                userEntity.getName(),
                userEntity.getEmail(),
                userEntity.getPassword());
    }

    public UserEntity toUserEntity(UserDTO userDTO) {
        return new UserEntity(
                userDTO.getId(),
                userDTO.getName(),
                userDTO.getEmail(),
                userDTO.getPassword());
    }
}
