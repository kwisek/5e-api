package pl.kwisek.dnd5e.dto.response;

import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import pl.kwisek.dnd5e.enumeration.Category;

import java.util.Collection;

@AllArgsConstructor
@Getter
public class SkillDetailsResponse extends BaseEntityResponse {

    @Schema(description = "Unique index, format: skill-X.", example = "skill-perception")
    private String index;

    @Schema(description = "Category. For this schema, always will be set to 'Skill'.", example = "Skill")
    private Category category;

    @Schema(description = "Subcategory of a Skill. Currently there are no subcategories, so will always be set to 'Skill'.", example = "Skill")
    private String subCategory;

    @Schema(description = "Exact name.", example = "Perception")
    private String name;

    @Schema(description = "Source. Entities are mostly originating from Player's Handbook.", example = "Player's Handbook")
    private String source;

    @Schema(description = "Ability to which this Skill belongs. Possible values: Strength, Dexterity, Constitution, Wisdom, Intelligence, Charisma.", example = "Wisdom")
    private String ability;

    @ArraySchema(schema = @Schema(description = "Description paragraph"))
    private Collection<String> description;
}
