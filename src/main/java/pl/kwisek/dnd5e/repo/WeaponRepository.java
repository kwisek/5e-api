package pl.kwisek.dnd5e.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.kwisek.dnd5e.entity.WeaponEntity;

public interface WeaponRepository extends JpaRepository<WeaponEntity, String> {
    
}
