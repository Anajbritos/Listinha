package io.ana.julia.listinha.data;

import io.ana.julia.listinha.data.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<ItemEntity, Long> {
    Boolean existsByDescription(String description);
}
