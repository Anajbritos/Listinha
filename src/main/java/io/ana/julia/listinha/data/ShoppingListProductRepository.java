package io.ana.julia.listinha.data;

import io.ana.julia.listinha.data.entity.ShoppingListProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShoppingListItemRepository extends JpaRepository<ShoppingListProductEntity,Long> {

    List<ShoppingListProductEntity> findAllByShoppingListId(Long shoppingListId);
}
