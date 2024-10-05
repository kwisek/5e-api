package pl.kwisek.dnd5e.dto.response;

import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import pl.kwisek.dnd5e.enumeration.Category;

import java.util.Collection;

@Data
public class BaseEntityResponse {
    @Schema(example = "unique-index")
    String index;

    @Schema(example = "Category")
    Category category;

    @Schema(example = "SubCategory")
    String subCategory;

    @Schema(example = "Name")
    String name;

    @Schema(example = "Player's Handbook (usually)")
    String source;

    @ArraySchema(schema = @Schema(example = "First paragraph of the description."))
    Collection<String> description;
}
