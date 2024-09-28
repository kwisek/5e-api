package pl.kwisek.dnd5e.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.kwisek.dnd5e.dto.response.ContainerDetailsResponse;
import pl.kwisek.dnd5e.entity.BaseEntity;
import pl.kwisek.dnd5e.entity.ContainerEntity;

import java.util.Collection;

@Mapper(componentModel = "spring")
public abstract class ContainerDetailsMapper {
    @Mapping(source = "baseEntity.indexId", target = "index")
    @Mapping(source = "baseEntity.category", target = "category")
    @Mapping(source = "baseEntity.subCategory", target = "subCategory")
    @Mapping(source = "baseEntity.name", target = "name")
    @Mapping(source = "baseEntity.source", target = "source")
    @Mapping(source = "containerEntity.cost", target = "cost")
    @Mapping(source = "containerEntity.weight", target = "weight")
    @Mapping(source = "containerEntity.capacity", target = "capacity")
    @Mapping(source = "description", target = "description")
    public abstract ContainerDetailsResponse toContainerDetailsResponse(BaseEntity baseEntity, ContainerEntity containerEntity, Collection<String> description);
}
