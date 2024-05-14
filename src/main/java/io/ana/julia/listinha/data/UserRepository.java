package io.ana.julia.listinha.data;

import io.ana.julia.listinha.data.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {

    Boolean existsByEmail(String email);
}
