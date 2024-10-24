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

    @Schema(description = "Unique index, format: spell-X.", example = "spell-bigbys-hand")
    private String index;

    @Schema(description = "Category. For this schema, always will be set to 'Spell'.", example = "Spell")
    private Category category;

    @Schema(description = "Subcategory of a Spell.", example = "Spell")
    private String subCategory;

    @Schema(description = "Exact name.", example = "Bigby's Hand")
    private String name;

    @Schema(description = "Source. Entities are mostly originating from Player's Handbook.", example = "Player's Handbook")
    private String source;

    @Schema(description = "Components required by this spell")
    private SpellComponentsSection components;

    @Schema(description = "Spell level.", example = "5")
    private Integer level;

    @Schema(description = "Spell range.", example = "120 feet")
    private String range;

    @Schema(description = "Spell school.", example = "Evocation")
    private String school;

    @Schema(description = "Duration of a spell.", example = "Concentration, up to 1 minute")
    private String duration;

    @Schema(description = "Whether ritual is required (true) or not (false).", example = "false")
    private Boolean ritual;

    @Schema(description = "Casting time. Possible value formats are: 'Instant', '1 action', or '_ actions'.", example = "1 action")
    private String castingTime;

    @ArraySchema(schema = @Schema(description = "Class associated with this Spell.", example = "Artificer"))
    private Collection<String> classes;

    @Schema(description = "Describes advantages when a spell is casted using a higher level spell slot.", example = "When you cast this spell using a spell slot of 6th level or higher, the damage from the clenched fist option increases by 2d8 and the damage from the grasping hand increases by 2d6 for each slot level above 5th.")
    private String higherLevel;

    @ArraySchema(schema = @Schema(description = "Description paragraph."))
    private Collection<String> description;
}
