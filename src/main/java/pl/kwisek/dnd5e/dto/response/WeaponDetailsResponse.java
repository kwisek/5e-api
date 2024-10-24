package pl.kwisek.dnd5e.dto.response;

import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import pl.kwisek.dnd5e.enumeration.Category;

import java.util.Collection;

@AllArgsConstructor
@Getter
public class WeaponDetailsResponse extends BaseEntityResponse {

    @Schema(description = "Unique index, format: weapon-X.", example = "weapon-longsword")
    private String index;

    @Schema(description = "Category. For this schema, always will be set to 'Weapon'.", example = "Weapon")
    private Category category;

    @Schema(description = "Subcategory of a Weapon.", example = "Martial Weapons")
    private String subCategory;

    @Schema(description = "Exact name.", example = "Longsword")
    private String name;

    @Schema(description = "Source. Entities are mostly originating from Player's Handbook.", example = "Player's Handbook")
    private String source;

    @Schema(description = "Value, format: '___,___ _p'. Possible currencies are: pp, gp, sp, cp.", example = "15 gp")
    private String cost;

    @Schema(description = "Weight in lbs, format: '_ lb.'", example = "3 lb.")
    private String weight;

    @Schema(description = "Damage type associated with a Weapon.", example = "slashing")
    private String damageType;

    @Schema(description = "Damage roll for a Weapon.", example = "1d8")
    private String damageRoll;

    @ArraySchema(schema = @Schema(description = "Weapon property", example = "Versatile (1d10)"))
    private Collection<String> properties;

    @Schema(description = "Weight in lbs, format: '_ lb.'", example = "65 lb.")
    private Collection<String> description;
}
