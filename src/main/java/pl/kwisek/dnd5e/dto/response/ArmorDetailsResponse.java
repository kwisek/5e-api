package pl.kwisek.dnd5e.dto.response;

import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;
import pl.kwisek.dnd5e.enumeration.Category;

import java.util.Collection;

@Schema(description = "Full details of an Armor.")
@AllArgsConstructor
@Getter
public class ArmorDetailsResponse extends BaseEntityResponse {

    @Schema(description = "Unique index, format: armor-X.", example = "armor-plate")
    private String index;

    @Schema(description = "Category. For this schema, always will be set to 'Armor'.", example = "Armor")
    private Category category;

    @Schema(description = "Subcategory of an Armor.", example = "HeavyArmor")
    private String subCategory;

    @Schema(description = "Exact name.", example = "Plate")
    private String name;

    @Schema(description = "Source. Entities are mostly originating from Player's Handbook.", example = "Player's Handbook")
    private String source;

    @Schema(description = "Value, format: '___,___ _p'. Possible currencies are: pp, gp, sp, cp.", example = "1,500 gp")
    private String cost;

    @Schema(description = "Weight in lbs, format: '_ lb.'", example = "65 lb.")
    private String weight;

    @Schema(description = "Armor class provided by this Armor, according to the Source. Represented as a number.", example = "18")
    private String armorClass;

    @Schema(description = "Strength required to carry this Armor, according to the Source. Represented as a number.", example = "Str 15")
    private String strengthRequired;

    @Schema(description = "A boolean telling whether this Armor causes stealth disadvantage (true) or not (false).", example = "true")
    private Boolean stealthDisadvantage;

    @ArraySchema(schema = @Schema(description = "Description paragraph"))
    private Collection<String> description;
}