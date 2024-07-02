package pl.kwisek.dnd5e.mapper;

import org.springframework.stereotype.Component;
import pl.kwisek.dnd5e.dto.response.WeaponIdsResponse;
import pl.kwisek.dnd5e.dto.response.WeaponResponse;
import pl.kwisek.dnd5e.entity.WeaponEntity;

import java.util.LinkedList;
import java.util.List;

@Component
public class WeaponMapper {

    public WeaponResponse toWeaponResponse(WeaponEntity weaponEntity) {
        return new WeaponResponse(
                weaponEntity.getName(),
                weaponEntity.getDescription(),
                weaponEntity.getDamageRoll(),
                weaponEntity.getDamageType(),
                weaponEntity.getProperties(),
                weaponEntity.getWeight(),
                weaponEntity.getValue(),
                weaponEntity.getCategory(),
                weaponEntity.getSource()
        );
    }

    public WeaponIdsResponse toWeaponIdsResponse(List<String> ids) {
        return new WeaponIdsResponse(ids);
    }
}
