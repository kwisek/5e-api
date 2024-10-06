package pl.kwisek.dnd5e.dto.response;

import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import pl.kwisek.dnd5e.enumeration.Category;

import java.util.Collection;

@AllArgsConstructor
@Getter
public class ItemDetailsResponse extends BaseEntityResponse {

    @Schema(example = "simpleitem-bell")
    private String index;

    @Schema(example = "Simple Item")
    private Category category;

    @Schema(example = "Common Item")
    private String subCategory;

    @Schema(example = "Bell")
    private String name;

    @Schema(example = "Player's Handbook")
    private String source;

    @Schema(example = "1 gp")
    private String cost;

    @Schema(example = "-")
    private String weight;

    @ArraySchema(schema = @Schema(example = "A bell is a small metal device that produces a ringing sound when struck. It can be used for signaling, communication, or as an alarm."))
    private Collection<String> description;
}
