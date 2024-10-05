package pl.kwisek.dnd5e.dto.response;

import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Value;
import pl.kwisek.dnd5e.enumeration.Category;

import java.util.Collection;

@Value
public class ContainerDetailsResponse extends BaseEntityResponse {

    @Schema(example = "container-barrel")
    String index;

    @Schema(example = "Container")
    Category category;

    @Schema(example = "Container")
    String subCategory;

    @Schema(example = "Barrel")
    String name;

    @Schema(example = "Player's Handbook")
    String source;

    @Schema(example = "2 gp")
    String cost;

    @Schema(example = "70 lb.")
    String weight;

    @Schema(example = "40 gallons liquid, 4 cubic feet solid")
    String capacity;

    @ArraySchema(schema = @Schema(example = "A barrel is a large, cylindrical container made of wooden staves and metal hoops."))
    Collection<String> description;
}
