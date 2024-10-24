package pl.kwisek.dnd5e.dto.response;

import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import pl.kwisek.dnd5e.enumeration.Category;

import java.util.Collection;

@AllArgsConstructor
@Getter
public class ItemDetailsResponse extends BaseEntityResponse {

    @Schema(description = "Unique index, format: simpleitem-X.", example = "simpleitem-bell")
    private String index;

    @Schema(description = "Category. For this schema, always will be set to 'SimpleItem'.", example = "SimpleItem")
    private Category category;

    @Schema(description = "Subcategory of a Simple Item.", example = "CommonItem")
    private String subCategory;

    @Schema(description = "Exact name.", example = "Bell")
    private String name;

    @Schema(description = "Source. Entities are mostly originating from Player's Handbook.", example = "Player's Handbook")
    private String source;

    @Schema(description = "Value, format: '___,___ _p'. Possible currencies are: pp, gp, sp, cp.", example = "1 gp")
    private String cost;

    @Schema(description = "Weight in lbs, format: '_ lb.'", example = "")
    private String weight;

    @ArraySchema(schema = @Schema(description = "Description paragraph"))
    private Collection<String> description;
}
