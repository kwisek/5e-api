package pl.kwisek.dnd5e.dto.response;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Value;

import java.util.Collection;

@Value
public class ListOfIndexesResponse {
    @ArraySchema(schema = @Schema(example = "weapon-longsword"))
    Collection<String> indexes;
}
