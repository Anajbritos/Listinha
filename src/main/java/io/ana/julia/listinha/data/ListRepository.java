package io.ana.julia.listinha.data;

import io.ana.julia.listinha.data.entity.ListEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListRepository extends JpaRepository<ListEntity,Long> {

    Boolean existsByDescription(String description);
}
