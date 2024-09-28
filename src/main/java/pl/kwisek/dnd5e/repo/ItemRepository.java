package pl.kwisek.dnd5e.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.kwisek.dnd5e.entity.ItemEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface ItemRepository extends JpaRepository<ItemEntity, String> {

    @Query("SELECT be.name FROM BaseEntity be WHERE be.category LIKE 'SimpleItem'")
    List<String> getNames();

    @Query("SELECT be.indexId FROM BaseEntity be WHERE be.category LIKE 'SimpleItem'")
    List<String> getIndexes();

    @Query("SELECT ie FROM ItemEntity ie WHERE ie.entityId = :indexId")
    Optional<ItemEntity> findByIndex(@Param("indexId") String index);
}
