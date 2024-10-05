package pl.kwisek.dnd5e.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.kwisek.dnd5e.dto.response.ConceptDetailsResponse;
import pl.kwisek.dnd5e.entity.ConceptEntity;

import java.util.Collection;

@Mapper(componentModel = "spring")
public abstract class ConceptDetailsMapper {

    @Mapping(source = "conceptEntity.indexId", target = "index")
    @Mapping(expression = "java(pl.kwisek.dnd5e.enumeration.Category.fromValue(conceptEntity.getCategory()))", target = "category")
    @Mapping(source = "conceptEntity.subCategory", target = "subCategory")
    @Mapping(source = "conceptEntity.name", target = "name")
    @Mapping(source = "conceptEntity.source", target = "source")
    @Mapping(source = "description", target = "description")
    public abstract ConceptDetailsResponse toConceptDetailsResponse(ConceptEntity conceptEntity, Collection<String> description);
}
