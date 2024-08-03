package pl.kwisek.dnd5e.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.kwisek.dnd5e.dto.response.EquipmentPackDetailsResponse;
import pl.kwisek.dnd5e.dto.response.WeaponDetailsResponse;
import pl.kwisek.dnd5e.entity.BaseEntity;
import pl.kwisek.dnd5e.entity.EquipmentPackEntity;
import pl.kwisek.dnd5e.entity.WeaponEntity;

import java.util.Collection;

@Mapper(componentModel = "spring")
public abstract class EquipmentPackDetailsResponseMapper {
    @Mapping(source = "baseEntity.indexId", target = "index")
    @Mapping(source = "baseEntity.category", target = "category")
    @Mapping(source = "baseEntity.subCategory", target = "subCategory")
    @Mapping(source = "baseEntity.name", target = "name")
    @Mapping(source = "baseEntity.source", target = "source")
    @Mapping(source = "equipmentPackEntity.cost", target = "cost")
    @Mapping(source = "equipmentPackEntity.weight", target = "weight")
    @Mapping(target = "contents", expression = "java(java.util.Arrays.asList(equipmentPackEntity.getContents().split(\", \")))")
    @Mapping(source = "description", target = "description")
    public abstract EquipmentPackDetailsResponse from(BaseEntity baseEntity, EquipmentPackEntity equipmentPackEntity, Collection<String> description);
}
