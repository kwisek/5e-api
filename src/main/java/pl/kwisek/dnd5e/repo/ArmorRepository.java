package pl.kwisek.dnd5e.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.kwisek.dnd5e.entity.ArmorEntity;
import pl.kwisek.dnd5e.entity.BaseEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface ArmorRepository extends JpaRepository<BaseEntity, String> {
    @Query("SELECT e.name FROM BaseEntity e WHERE e.category LIKE 'Armor'")
    List<String> getNames();

    @Query("SELECT e.indexId FROM BaseEntity e WHERE e.category LIKE 'Armor'")
    List<String> getIndexes();

    @Query("SELECT a FROM ArmorEntity a WHERE a.entityId = :indexId")
    Optional<ArmorEntity> findByIndex(@Param("indexId") String index);
}
