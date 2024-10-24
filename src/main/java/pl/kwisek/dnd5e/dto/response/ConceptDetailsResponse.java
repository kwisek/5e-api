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

    @Schema(description = "Unique index, format: concept-X.", example = "concept-climbing")
    private String index;

    @Schema(description = "Category. For this schema, always will be set to 'Concept'.", example = "Concept")
    private Category category;

    @Schema(description = "Subcategory of a Concept.", example = "Movement type")
    private String subCategory;

    @Schema(description = "Exact name.", example = "Climbing")
    private String name;

    @Schema(description = "Source. Entities are mostly originating from Player's Handbook.", example = "Player's Handbook")
    private String source;

    @ArraySchema(schema = @Schema(description = "Description paragraph"))
    private Collection<String> description;
}
