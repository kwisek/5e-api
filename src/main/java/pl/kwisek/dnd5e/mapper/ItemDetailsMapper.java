package pl.kwisek.dnd5e.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.kwisek.dnd5e.dto.response.ItemDetailsResponse;
import pl.kwisek.dnd5e.entity.BaseEntity;
import pl.kwisek.dnd5e.entity.ItemEntity;

import java.util.Collection;

@Mapper(componentModel = "spring")
public abstract class ItemDetailsMapper {

    @Mapping(source = "baseEntity.indexId", target = "index")
    @Mapping(source = "baseEntity.category", target = "category")
    @Mapping(source = "baseEntity.subCategory", target = "subCategory")
    @Mapping(source = "baseEntity.name", target = "name")
    @Mapping(source = "baseEntity.source", target = "source")
    @Mapping(source = "itemEntity.cost", target = "cost")
    @Mapping(source = "itemEntity.weight", target = "weight")
    @Mapping(source = "description", target = "description")
    public abstract ItemDetailsResponse toItemDetailsResponse(BaseEntity baseEntity, ItemEntity itemEntity, Collection<String> description);

}
