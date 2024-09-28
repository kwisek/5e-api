package pl.kwisek.dnd5e.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.kwisek.dnd5e.dto.response.WeaponDetailsResponse;
import pl.kwisek.dnd5e.entity.BaseEntity;
import pl.kwisek.dnd5e.entity.WeaponEntity;

import java.util.Collection;

@Mapper(componentModel = "spring")
public abstract class WeaponDetailsMapper {

    @Mapping(source = "baseEntity.indexId", target = "index")
    @Mapping(source = "baseEntity.category", target = "category")
    @Mapping(source = "baseEntity.subCategory", target = "subCategory")
    @Mapping(source = "baseEntity.name", target = "name")
    @Mapping(source = "baseEntity.source", target = "source")
    @Mapping(source = "weaponEntity.cost", target = "cost")
    @Mapping(source = "weaponEntity.weight", target = "weight")
    @Mapping(source = "weaponEntity.damageType", target = "damageType")
    @Mapping(source = "weaponEntity.damageRoll", target = "damageRoll")
    @Mapping(target = "properties", expression = "java(java.util.Arrays.asList(weaponEntity.getProperties().split(\",\")))")
    @Mapping(source = "description", target = "description")
    public abstract WeaponDetailsResponse toWeaponDetailsResponse(BaseEntity baseEntity, WeaponEntity weaponEntity, Collection<String> description);
}
