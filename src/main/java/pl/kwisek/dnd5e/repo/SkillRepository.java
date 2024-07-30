package pl.kwisek.dnd5e.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.kwisek.dnd5e.entity.BaseEntity;
import pl.kwisek.dnd5e.entity.SkillEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface SkillRepository extends JpaRepository<BaseEntity, String> {
    @Query("SELECT e.name FROM BaseEntity e WHERE e.category LIKE 'Skill'")
    List<String> getNames();

    @Query("SELECT e.indexId FROM BaseEntity e WHERE e.category LIKE 'Skill'")
    List<String> getIndexes();

    @Query("SELECT a FROM SkillEntity a WHERE a.entityId = :indexId")
    Optional<SkillEntity> findByIndex(@Param("indexId") String index);
}