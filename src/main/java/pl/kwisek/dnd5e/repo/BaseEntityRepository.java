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

    @Query("SELECT be FROM BaseEntity be WHERE be.indexId = :indexId")
    Optional<BaseEntity> findByIndex(@Param("indexId") String index);

    @Query("SELECT be FROM BaseEntity be WHERE be.name = :name")
    Optional<BaseEntity> findByName(@Param("name") String name);

    @Query("SELECT be.indexId FROM BaseEntity be")
    Collection<String> getAllIndexes();
    @Query("SELECT be.name FROM BaseEntity be")
    Collection<String> getAllNames();
}
