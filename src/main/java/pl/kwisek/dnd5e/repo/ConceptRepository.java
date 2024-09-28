package pl.kwisek.dnd5e.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.kwisek.dnd5e.entity.BaseEntity;
import pl.kwisek.dnd5e.entity.ConceptEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface ConceptRepository extends JpaRepository<BaseEntity, String> {
    @Query("SELECT be.name FROM BaseEntity be WHERE be.category LIKE 'Concept'")
    List<String> getNames();

    @Query("SELECT be.indexId FROM BaseEntity be WHERE be.category LIKE 'Concept'")
    List<String> getIndexes();

    @Query("SELECT ae FROM ArmorEntity ae WHERE ae.entityId = :indexId")
    Optional<ConceptEntity> findByIndex(@Param("indexId") String index);
}
