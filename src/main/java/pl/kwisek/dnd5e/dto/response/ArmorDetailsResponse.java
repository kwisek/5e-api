package pl.kwisek.dnd5e.dto.response;

import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Value;
import pl.kwisek.dnd5e.enumeration.Category;

import java.util.Collection;

@Value
public class ArmorDetailsResponse extends BaseEntityResponse {

    @Schema(example = "armor-plate")
    String index;

    @Schema(example = "Armor")
    Category category;

    @Schema(example = "Heavy Armor")
    String subCategory;

    @Schema(example = "Plate")
    String name;

    @Schema(example = "Player's Handbook")
    String source;

    @Schema(example = "1,500 gp")
    String cost;

    @Schema(example = "65 lb.")
    String weight;

    @Schema(example = "18")
    String armorClass;

    @Schema(example = "Str 15")
    String strengthRequired;

    @Schema(example = "true")
    Boolean stealthDisadvantage;

    @ArraySchema(schema = @Schema(example = "Plate armor consists of shaped, interlocking metal plates to cover the entire body. It provides the highest level of protection among all armors."))
    Collection<String> description;
}
