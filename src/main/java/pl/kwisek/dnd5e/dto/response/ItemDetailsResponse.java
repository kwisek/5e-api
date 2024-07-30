package pl.kwisek.dnd5e.dto.response;

import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Value;

import java.util.Collection;

@Value
public class ItemDetailsResponse extends BaseEntityResponse {
    @Schema(example = "simpleitem-bell")
    String index;

    @Schema(example = "Simple Item")
    String category;

    @Schema(example = "Common Item")
    String subCategory;

    @Schema(example = "Bell")
    String name;

    @Schema(example = "Player's Handbook")
    String source;

    @Schema(example = "1 gp")
    String cost;

    @Schema(example = "-")
    String weight;

    @ArraySchema(schema = @Schema(example = "A bell is a small metal device that produces a ringing sound when struck. It can be used for signaling, communication, or as an alarm."))
    Collection<String> description;
}
