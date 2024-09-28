package pl.kwisek.dnd5e.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.kwisek.dnd5e.dto.response.SkillDetailsResponse;
import pl.kwisek.dnd5e.entity.BaseEntity;
import pl.kwisek.dnd5e.entity.SkillEntity;
import java.util.Collection;

@Mapper(componentModel = "spring")
public abstract class SkillDetailsMapper {
    @Mapping(source = "baseEntity.indexId", target = "index")
    @Mapping(source = "baseEntity.category", target = "category")
    @Mapping(source = "baseEntity.subCategory", target = "subCategory")
    @Mapping(source = "baseEntity.name", target = "name")
    @Mapping(source = "baseEntity.source", target = "source")
    @Mapping(source = "skillEntity.ability", target = "ability")
    @Mapping(source = "description", target = "description")
    public abstract SkillDetailsResponse toSkillDetailsResponse(BaseEntity baseEntity, SkillEntity skillEntity, Collection<String> description);
}
