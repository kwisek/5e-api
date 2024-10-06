package pl.kwisek.dnd5e.dto.response;

import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import pl.kwisek.dnd5e.dto.SpellComponentsSection;
import pl.kwisek.dnd5e.enumeration.Category;

import java.util.Collection;

@AllArgsConstructor
@Getter
public class SpellDetailsResponse extends BaseEntityResponse {

    @Schema(example = "spell-bigbys-hand")
    private String index;

    @Schema(example = "Spell")
    private Category category;

    @Schema(example = "Spell")
    private String subCategory;

    @Schema(example = "Bigby's Hand")
    private String name;

    @Schema(example = "Player's Handbook")
    private String source;

    @Schema(description = "Components required by this spell")
    private SpellComponentsSection components;

    @Schema(example = "5")
    private Integer level;

    @Schema(example = "120 feet")
    private String range;

    @Schema(example = "Evocation")
    private String school;

    @Schema(example = "Concentration, up to 1 minute")
    private String duration;

    @Schema(example = "false")
    private Boolean ritual;

    @Schema(example = "1 action")
    private String castingTime;

    @ArraySchema(schema = @Schema(example = "Artificer"))
    private Collection<String> classes;

    @Schema(example = "When you cast this spell using a spell slot of 6th level or higher, the damage from the clenched fist option increases by 2d8 and the damage from the grasping hand increases by 2d6 for each slot level above 5th.")
    private String higherLevel;

    @ArraySchema(schema = @Schema(example = ""))
    private Collection<String> description;
}
