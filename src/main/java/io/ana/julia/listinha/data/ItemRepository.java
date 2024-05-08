package io.ana.julia.listinha.data;

import io.ana.julia.listinha.data.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<ItemEntity, Long> {

    public Boolean existsByDescription(String description);
}
