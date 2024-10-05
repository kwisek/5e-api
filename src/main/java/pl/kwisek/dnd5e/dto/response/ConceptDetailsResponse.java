package pl.kwisek.dnd5e.dto.response;

import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Value;
import pl.kwisek.dnd5e.enumeration.Category;

import java.util.Collection;

@Value
public class ConceptDetailsResponse extends BaseEntityResponse {

    @Schema(example = "concept-climbing")
    String index;

    @Schema(example = "Concept")
    Category category;

    @Schema(example = "Movement type")
    String subCategory;

    @Schema(example = "Climbing")
    String name;

    @Schema(example = "Player's Handbook")
    String source;

    @ArraySchema(schema = @Schema(example = "While climbing, each foot of movement costs 1 extra foot (2 extra feet in difficult terrain), unless a creature has a climbing speed. At the GM's option, climbing a slippery vertical surface or one with few handholds requires a successful Strength (Athletics) check."))
    Collection<String> description;
}
