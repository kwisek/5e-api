package pl.kwisek.dnd5e.dto.response;

import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.kwisek.dnd5e.enumeration.Category;

import java.util.Collection;

@NoArgsConstructor
@Getter @Setter
public class BaseEntityResponse {

    @Schema(example = "unique-index")
    private String index;

    @Schema(example = "Category")
    private Category category;

    @Schema(example = "SubCategory")
    private String subCategory;

    @Schema(example = "Name")
    private String name;

    @Schema(example = "Player's Handbook (usually)")
    private String source;

    @ArraySchema(schema = @Schema(example = "First paragraph of the description."))
    private Collection<String> description;
}
