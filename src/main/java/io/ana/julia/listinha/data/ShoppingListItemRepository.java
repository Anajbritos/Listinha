package io.ana.julia.listinha.data;

import io.ana.julia.listinha.data.entity.ShoppingListEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingListItemRepository extends JpaRepository<ShoppingListEntity,Long> {
}
