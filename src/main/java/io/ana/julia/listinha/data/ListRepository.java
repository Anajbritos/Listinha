package io.ana.julia.listinha.data;

import io.ana.julia.listinha.data.entity.ListEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ListRepository extends JpaRepository<ListEntity,Long> {
}
