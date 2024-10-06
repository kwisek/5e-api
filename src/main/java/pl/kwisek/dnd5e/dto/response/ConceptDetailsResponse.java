package pl.kwisek.dnd5e.dto.response;

import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import pl.kwisek.dnd5e.enumeration.Category;

import java.util.Collection;

@AllArgsConstructor
@Getter
public class ConceptDetailsResponse extends BaseEntityResponse {

    @Schema(example = "concept-climbing")
    private String index;

    @Schema(example = "Concept")
    private Category category;

    @Schema(example = "Movement type")
    private String subCategory;

    @Schema(example = "Climbing")
    private String name;

    @Schema(example = "Player's Handbook")
    private String source;

    @ArraySchema(schema = @Schema(example = "While climbing, each foot of movement costs 1 extra foot (2 extra feet in difficult terrain), unless a creature has a climbing speed. At the GM's option, climbing a slippery vertical surface or one with few handholds requires a successful Strength (Athletics) check."))
    private Collection<String> description;
}
