package pl.kwisek.dnd5e.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.kwisek.dnd5e.entity.BaseEntity;

import java.util.Collection;

@Repository
public interface EntityDescriptionRepository extends JpaRepository<BaseEntity, String> {
    @Query("SELECT paragraph FROM DescriptionEntity de WHERE de.id.entityId = :indexId")
    Collection<String> findByIndex(@Param("indexId") String index);
}
