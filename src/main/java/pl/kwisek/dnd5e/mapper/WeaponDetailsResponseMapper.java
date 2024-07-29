package pl.kwisek.dnd5e.mapper;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import pl.kwisek.dnd5e.dto.response.WeaponDetailsResponse;
import pl.kwisek.dnd5e.entity.BaseEntity;
import pl.kwisek.dnd5e.entity.WeaponEntity;

import java.util.Arrays;
import java.util.Collection;

@Mapper(componentModel = "spring")
public abstract class WeaponDetailsResponseMapper {
    @Mapping(source = "baseEntity.indexId", target = "index")
    @Mapping(source = "baseEntity.category", target = "category")
    @Mapping(source = "baseEntity.subCategory", target = "subCategory")
    @Mapping(source = "baseEntity.name", target = "name")
    @Mapping(source = "baseEntity.source", target = "source")
    @Mapping(source = "weaponEntity.cost", target = "cost")
    @Mapping(source = "weaponEntity.weight", target = "weight")
    @Mapping(source = "weaponEntity.damageType", target = "damageType")
    @Mapping(source = "weaponEntity.damageRoll", target = "damageRoll")
    @Mapping(target = "properties", expression = "java(new java.util.ArrayList<>())") // values handled by mapProperties()
    @Mapping(source = "description", target = "description")
    public abstract WeaponDetailsResponse from(BaseEntity baseEntity, WeaponEntity weaponEntity, Collection<String> description);

    @AfterMapping
    protected void mapProperties(WeaponEntity weaponEntity, @MappingTarget WeaponDetailsResponse target) {
        target.getProperties().addAll(Arrays.stream(weaponEntity.getProperties().split(",")).toList());
    }
}
