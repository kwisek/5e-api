package pl.kwisek.dnd5e.dto.response;

import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Value;

import java.util.Collection;

@Value
public class WeaponDetailsResponse {
    @Schema(example = "weapon_longsword")
    String index;

    @Schema(example = "Weapon")
    String category;

    @Schema(example = "Martial Weapons")
    String subCategory;

    @Schema(example = "Longsword")
    String name;

    @Schema(example = "Player's Handbook")
    String source;

    @Schema(example = "15 gp")
    String cost;

    @Schema(example = "3 lb.")
    String weight;

    @Schema(example = "slashing")
    String damageType;

    @Schema(example = "1d8")
    String damageRoll;

    @ArraySchema(schema = @Schema(example = "Versatile (1d10)"))
    Collection<String> properties;

    @ArraySchema(schema = @Schema(example = "A longsword is a versatile weapon capable of being wielded with one or two hands."))
    Collection<String> description;
}
