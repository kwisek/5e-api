package pl.kwisek.dnd5e.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.kwisek.dnd5e.entity.ItemEntity;
import pl.kwisek.dnd5e.entity.SpellEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface SpellRepository extends JpaRepository<ItemEntity, String> {
    @Query("SELECT e.name FROM BaseEntity e WHERE e.category LIKE 'Spell'")
    List<String> getNames();

    @Query("SELECT e.indexId FROM BaseEntity e WHERE e.category LIKE 'Spell'")
    List<String> getIndexes();

    @Query("SELECT s FROM SpellEntity s WHERE s.entityId = :indexId")
    Optional<SpellEntity> findByIndex(@Param("indexId") String index);
}
