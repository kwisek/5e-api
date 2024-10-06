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

    @Schema(example = "skill-perception")
    private String index;

    @Schema(example = "Skill")
    private Category category;

    @Schema(example = "Skill")
    private String subCategory;

    @Schema(example = "Perception")
    private String name;

    @Schema(example = "Player's Handbook")
    private String source;

    @Schema(example = "Wisdom")
    private String ability;

    @ArraySchema(schema = @Schema(example = "Your Perception check lets you spot, hear, or otherwise detect the presence of something. It measures your general awareness of your surroundings and the keenness of your senses. For example, you might try to hear a conversation through a closed door, eavesdrop under an open window, or hear monsters moving stealthily in the forest. Or you might try to spot things that are obscured or easy to miss, whether they are orcs lying in ambush on a road, thugs hiding in the shadows of an alley, or candlelight under a closed secret door."))
    private Collection<String> description;
}
