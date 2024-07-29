package pl.kwisek.dnd5e.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.kwisek.dnd5e.entity.BaseEntity;
import pl.kwisek.dnd5e.entity.WeaponEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface WeaponRepository extends JpaRepository<BaseEntity, String> {
    @Query("SELECT e.name FROM BaseEntity e WHERE e.category LIKE 'Weapon'")
    List<String> getWeaponNames();

    @Query("SELECT w FROM WeaponEntity w WHERE w.entityId = :indexId")
    Optional<WeaponEntity> findByIndex(@Param("indexId") String index);
}
