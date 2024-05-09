package io.ana.julia.listinha.data;

import io.ana.julia.listinha.data.entity.ShoppingListEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingListRepository extends JpaRepository<ShoppingListEntity,Long> {

    Boolean existsByDescription(String description);
}
