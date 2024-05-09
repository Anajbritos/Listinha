package io.ana.julia.listinha.data;

import io.ana.julia.listinha.data.entity.ShoppingListEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShoppingListRepository extends JpaRepository<ShoppingListEntity,Long> {

     Boolean existsByDescriptionIgnoreCaseAndId(String description, Long id);
     Boolean existsByDescription(String description);

    List<ShoppingListEntity> findAllByUserId(Long userId);
}
