package pl.kwisek.dnd5e.dto.response;

import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Value;
import pl.kwisek.dnd5e.enumeration.Category;

import java.util.Collection;

@Value
public class SkillDetailsResponse extends BaseEntityResponse {

    @Schema(example = "skill-perception")
    String index;

    @Schema(example = "Skill")
    Category category;

    @Schema(example = "Skill")
    String subCategory;

    @Schema(example = "Perception")
    String name;

    @Schema(example = "Player's Handbook")
    String source;

    @Schema(example = "Wisdom")
    String ability;

    @ArraySchema(schema = @Schema(example = "Your Perception check lets you spot, hear, or otherwise detect the presence of something. It measures your general awareness of your surroundings and the keenness of your senses. For example, you might try to hear a conversation through a closed door, eavesdrop under an open window, or hear monsters moving stealthily in the forest. Or you might try to spot things that are obscured or easy to miss, whether they are orcs lying in ambush on a road, thugs hiding in the shadows of an alley, or candlelight under a closed secret door."))
    Collection<String> description;
}
