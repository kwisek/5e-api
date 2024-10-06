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

    @Schema(example = "weapon_longsword")
    private String index;

    @Schema(example = "Weapon")
    private Category category;

    @Schema(example = "Martial Weapons")
    private String subCategory;

    @Schema(example = "Longsword")
    private String name;

    @Schema(example = "Player's Handbook")
    private String source;

    @Schema(example = "15 gp")
    private String cost;

    @Schema(example = "3 lb.")
    private String weight;

    @Schema(example = "slashing")
    private String damageType;

    @Schema(example = "1d8")
    private String damageRoll;

    @ArraySchema(schema = @Schema(example = "Versatile (1d10)"))
    private Collection<String> properties;

    @ArraySchema(schema = @Schema(example = "A longsword is a versatile weapon capable of being wielded with one or two hands."))
    private Collection<String> description;
}
