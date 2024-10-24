package pl.kwisek.dnd5e.dto.response;

import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Collection;

@AllArgsConstructor
@Getter
public class ListOfNamesResponse {

    @ArraySchema(schema = @Schema(description = "Name of an entity.", example = "Longsword"))
    private Collection<String> names;
}
