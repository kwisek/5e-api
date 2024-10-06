package pl.kwisek.dnd5e.dto.response;

import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Collection;

@AllArgsConstructor
@Getter
public class ListOfIndexesResponse {

    @ArraySchema(schema = @Schema(example = "weapon-longsword"))
    private Collection<String> indexes;
}
