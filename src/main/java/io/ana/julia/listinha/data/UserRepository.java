package io.ana.julia.listinha.data;

import io.ana.julia.listinha.data.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {

    Boolean existsByEmail(String email);
}
