package io.ana.julia.listinha.data.mapper;

import io.ana.julia.listinha.data.dto.UserDto;
import io.ana.julia.listinha.data.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserDto toUserDTO(UserEntity userEntity) {
        return new UserDto(
                userEntity.getId(),
                userEntity.getFirstName(),
                userEntity.getLastName(),
                userEntity.getEmail(),
                userEntity.getPassword(),
                userEntity.getActive(),
                userEntity.getCreateAt(),
                userEntity.getUpdateAt());
    }

    public UserEntity toUserEntity(UserDto userDTO) {
        return new UserEntity(
                userDTO.getId(),
                userDTO.getFirstName(),
                userDTO.getLastName(),
                userDTO.getEmail(),
                userDTO.getPassword(),
                userDTO.getActive(),
                userDTO.getCreateAt(),
                userDTO.getUpdateAt());
    }
}
