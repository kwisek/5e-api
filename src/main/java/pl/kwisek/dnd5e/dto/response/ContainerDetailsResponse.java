package pl.kwisek.dnd5e.dto.response;

import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import pl.kwisek.dnd5e.enumeration.Category;

import java.util.Collection;

@AllArgsConstructor
@Getter
public class ContainerDetailsResponse extends BaseEntityResponse {

    @Schema(description = "Unique index, format: Container-X.", example = "container-barrel")
    private String index;

    @Schema(description = "Category. For this schema, always will be set to 'Container'.", example = "Container")
    private Category category;

    @Schema(description = "Subcategory of a Container. Currently there are no subcategories, so will always be set to 'Container'.", example = "Container")
    private String subCategory;

    @Schema(description = "Exact name.", example = "Barrel")
    private String name;

    @Schema(description = "Source. Entities are mostly originating from Player's Handbook.", example = "Player's Handbook")
    private String source;

    @Schema(description = "Value, format: '___,___ _p'. Possible currencies are: pp, gp, sp, cp.", example = "2 gp")
    private String cost;

    @Schema(description = "Weight in lbs, format: '_ lb.'", example = "70 lb.")
    private String weight;

    @Schema(description = "Describes Container capacity without any standardized format.", example = "40 gallons liquid, 4 cubic feet solid")
    private String capacity;

    @ArraySchema(schema = @Schema(description = "Description paragraph"))
    private Collection<String> description;
}
