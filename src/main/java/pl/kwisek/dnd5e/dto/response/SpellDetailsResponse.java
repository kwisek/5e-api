package pl.kwisek.dnd5e.dto.response;

import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Value;
import pl.kwisek.dnd5e.dto.SpellComponentsSection;
import pl.kwisek.dnd5e.enumeration.Category;

import java.util.Collection;

@Value
public class SpellDetailsResponse extends BaseEntityResponse {

    @Schema(example = "spell-bigbys-hand")
    String index;

    @Schema(example = "Spell")
    Category category;

    @Schema(example = "Spell")
    String subCategory;

    @Schema(example = "Bigby's Hand")
    String name;

    @Schema(example = "Player's Handbook")
    String source;

    @Schema(description = "Components required by this spell")
    SpellComponentsSection components;

    @Schema(example = "5")
    Integer level;

    @Schema(example = "120 feet")
    String range;

    @Schema(example = "Evocation")
    String school;

    @Schema(example = "Concentration, up to 1 minute")
    String duration;

    @Schema(example = "false")
    Boolean ritual;

    @Schema(example = "1 action")
    String castingTime;

    @ArraySchema(schema = @Schema(example = "Artificer"))
    Collection<String> classes;

    @Schema(example = "When you cast this spell using a spell slot of 6th level or higher, the damage from the clenched fist option increases by 2d8 and the damage from the grasping hand increases by 2d6 for each slot level above 5th.")
    String higherLevel;

    @ArraySchema(schema = @Schema(example = ""))
    Collection<String> description;
}
