package pl.kwisek.dnd5e.dto.response;

import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;
import pl.kwisek.dnd5e.enumeration.Category;

import java.util.Collection;

@AllArgsConstructor
@Getter
public class ArmorDetailsResponse extends BaseEntityResponse {

    @Schema(example = "armor-plate")
    private String index;

    @Schema(example = "Armor")
    private Category category;

    @Schema(example = "Heavy Armor")
    private String subCategory;

    @Schema(example = "Plate")
    private String name;

    @Schema(example = "Player's Handbook")
    private String source;

    @Schema(example = "1,500 gp")
    private String cost;

    @Schema(example = "65 lb.")
    private String weight;

    @Schema(example = "18")
    private String armorClass;

    @Schema(example = "Str 15")
    private String strengthRequired;

    @Schema(example = "true")
    private Boolean stealthDisadvantage;

    @ArraySchema(schema = @Schema(example = "Plate armor consists of shaped, interlocking metal plates to cover the entire body. It provides the highest level of protection among all armors."))
    private Collection<String> description;
}
