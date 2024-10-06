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

    @Schema(example = "container-barrel")
    private String index;

    @Schema(example = "Container")
    private Category category;

    @Schema(example = "Container")
    private String subCategory;

    @Schema(example = "Barrel")
    private String name;

    @Schema(example = "Player's Handbook")
    private String source;

    @Schema(example = "2 gp")
    private String cost;

    @Schema(example = "70 lb.")
    private String weight;

    @Schema(example = "40 gallons liquid, 4 cubic feet solid")
    private String capacity;

    @ArraySchema(schema = @Schema(example = "A barrel is a large, cylindrical container made of wooden staves and metal hoops."))
    private Collection<String> description;
}
