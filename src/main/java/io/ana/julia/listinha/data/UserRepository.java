package io.ana.julia.listinha.data;

import io.ana.julia.listinha.data.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity,Long> {

    public Boolean existsByEmail(String email);
}
