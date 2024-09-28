package pl.kwisek.dnd5e.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.kwisek.dnd5e.dto.response.ArmorDetailsResponse;
import pl.kwisek.dnd5e.entity.ArmorEntity;
import pl.kwisek.dnd5e.entity.BaseEntity;

import java.util.Collection;

@Mapper(componentModel = "spring")
public abstract class ArmorDetailsMapper {
    @Mapping(source = "baseEntity.indexId", target = "index")
    @Mapping(source = "baseEntity.category", target = "category")
    @Mapping(source = "baseEntity.subCategory", target = "subCategory")
    @Mapping(source = "baseEntity.name", target = "name")
    @Mapping(source = "baseEntity.source", target = "source")
    @Mapping(source = "armorEntity.cost", target = "cost")
    @Mapping(source = "armorEntity.weight", target = "weight")
    @Mapping(source = "armorEntity.armorClass", target = "armorClass")
    @Mapping(source = "armorEntity.strengthRequired", target = "strengthRequired")
    @Mapping(source = "armorEntity.stealthDisadvantage", target = "stealthDisadvantage")
    @Mapping(source = "description", target = "description")
    public abstract ArmorDetailsResponse toArmorDetailsResponse(BaseEntity baseEntity, ArmorEntity armorEntity, Collection<String> description);

    protected Boolean map(Integer value) {
        return value != null && value != 0;
    }
}
