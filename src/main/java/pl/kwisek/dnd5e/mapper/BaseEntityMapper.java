package pl.kwisek.dnd5e.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.kwisek.dnd5e.dto.response.BaseEntityResponse;
import pl.kwisek.dnd5e.entity.BaseEntity;
import pl.kwisek.dnd5e.enumeration.Category;

import java.util.Collection;

@Mapper(componentModel = "spring")
public abstract class BaseEntityMapper {


    @Mapping(target = "index", source = "baseEntity.indexId")
    @Mapping(target = "category", expression = "java(pl.kwisek.dnd5e.enumeration.Category.fromValue(baseEntity.getCategory()))")
    public abstract BaseEntityResponse toBaseEntityResponse(BaseEntity baseEntity, Collection<String> description);
}
