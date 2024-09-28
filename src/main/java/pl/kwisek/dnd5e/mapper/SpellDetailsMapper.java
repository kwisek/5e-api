package pl.kwisek.dnd5e.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.kwisek.dnd5e.dto.SpellComponentsSection;
import pl.kwisek.dnd5e.dto.response.SpellDetailsResponse;
import pl.kwisek.dnd5e.entity.BaseEntity;
import pl.kwisek.dnd5e.entity.SpellEntity;
import java.util.Collection;

@Mapper(componentModel = "spring")
public abstract class SpellDetailsMapper {
    @Mapping(source = "baseEntity.indexId", target = "index")
    @Mapping(source = "baseEntity.category", target = "category")
    @Mapping(source = "baseEntity.subCategory", target = "subCategory")
    @Mapping(source = "baseEntity.name", target = "name")
    @Mapping(source = "baseEntity.source", target = "source")
    @Mapping(source = "spellEntity.level", target = "level")
    @Mapping(source = "spellEntity.range", target = "range")
    @Mapping(source = "spellEntity.school", target = "school")
    @Mapping(source = "spellEntity.duration", target = "duration")
    @Mapping(source = "spellEntity.requiredRitual", target = "ritual")
    @Mapping(source = "spellEntity.castingTime", target = "castingTime")
    @Mapping(source = "spellEntity.higherLevel", target = "higherLevel")
    @Mapping(target = "components", expression = "java(mapComponents(spellEntity))")
    @Mapping(target = "classes", expression = "java(java.util.Arrays.asList(spellEntity.getClasses().split(\", \")))")
    @Mapping(source = "description", target = "description")
    public abstract SpellDetailsResponse toSpellDetailsResponse(BaseEntity baseEntity, SpellEntity spellEntity, Collection<String> description);

    @Mapping(source = "spellEntity.requiredComponentV", target = "V")
    @Mapping(source = "spellEntity.requiredComponentS", target = "S")
    @Mapping(source = "spellEntity.requiredComponentM", target = "M")
    @Mapping(source = "spellEntity.requiredMaterial", target = "material")
    public abstract SpellComponentsSection mapComponents(SpellEntity spellEntity);

    Boolean toSpellDetailsResponse(Integer value) { return value != null && value != 0; }
}
