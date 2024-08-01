package pl.kwisek.dnd5e.mapper;

import org.mapstruct.Mapper;
import pl.kwisek.dnd5e.dto.response.BaseEntityResponse;
import pl.kwisek.dnd5e.entity.BaseEntity;

import java.util.Collection;

@Mapper(componentModel = "spring")
public abstract class BaseEntityMapper {
    public abstract BaseEntityResponse from(BaseEntity baseEntity, Collection<String> description);
}
