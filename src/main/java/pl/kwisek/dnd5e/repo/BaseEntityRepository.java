package pl.kwisek.dnd5e.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.kwisek.dnd5e.entity.BaseEntity;

import java.util.Collection;
import java.util.Optional;

@Repository
public interface BaseEntityRepository extends JpaRepository<BaseEntity, String> {
    @Query("SELECT e FROM BaseEntity e WHERE e.indexId = :indexId")
    Optional<BaseEntity> findByIndex(@Param("indexId") String index);
    @Query("SELECT e.indexId FROM BaseEntity e")
    Collection<String> getAllIndexes();
    @Query("SELECT e.name FROM BaseEntity e")
    Collection<String> getAllNames();
}
