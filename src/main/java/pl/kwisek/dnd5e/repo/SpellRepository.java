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
    @Query("SELECT be.name FROM BaseEntity be WHERE be.category LIKE 'Spell'")
    List<String> getNames();

    @Query("SELECT be.indexId FROM BaseEntity be WHERE be.category LIKE 'Spell'")
    List<String> getIndexes();

    @Query("SELECT se FROM SpellEntity se WHERE se.entityId = :indexId")
    Optional<SpellEntity> findByIndex(@Param("indexId") String index);
}
