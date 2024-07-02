package pl.kwisek.dnd5e.dto.response;

import io.swagger.v3.oas.annotations.Parameter;
import lombok.Value;

import java.util.List;

@Value
public class WeaponResponse {

    @Parameter(description = "Weapon name", example = "Longsword")
    String name;

    @Parameter(description = "Description")
    List<String> description;

    @Parameter(description = "Damage roll rep", example = "1d8")
    String damageRoll;

    @Parameter(description = "Damage type", example = "Piercing")
    String damageType;

    @Parameter(description = "Additional weapon properties", example = "['Heavy', 'Two-handed']")
    List<String> properties;

    @Parameter(description = "Weight", example = "4 lb.")
    String weight;

    @Parameter(description = "Value", example = "15gp")
    String value;

    @Parameter(description = "Weapon category", example = "Martial weapons")
    String category;

    @Parameter(description = "Source", example = "Dungeon Master's Guide")
    String source;
}
