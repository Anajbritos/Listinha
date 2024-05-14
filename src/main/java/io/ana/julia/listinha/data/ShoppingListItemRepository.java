package io.ana.julia.listinha.data;

import io.ana.julia.listinha.data.entity.ShoppingListItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShoppingListItemRepository extends JpaRepository<ShoppingListItemEntity,Long> {

    List<ShoppingListItemEntity> findAllByShoppingListId(Long shoppingListId);
}
