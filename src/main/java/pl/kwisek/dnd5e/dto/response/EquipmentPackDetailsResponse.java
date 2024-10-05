package pl.kwisek.dnd5e.dto.response;

import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Value;
import pl.kwisek.dnd5e.enumeration.Category;

import java.util.Collection;

@Value
public class EquipmentPackDetailsResponse extends BaseEntityResponse {

    @Schema(example = "equipmentpack-priests-pack")
    String index;

    @Schema(example = "EquipmentPack")
    Category category;

    @Schema(example = "EquipmentPack")
    String subCategory;

    @Schema(example = "Priest's Pack")
    String name;

    @Schema(example = "Player's Handbook")
    String source;

    @Schema(example = "19 gp")
    String cost;

    @Schema(example = "-")
    String weight;

    @ArraySchema(schema = @Schema(example = "10 candles"))
    Collection<String> contents;

    @ArraySchema(schema = @Schema(example = ""))
    Collection<String> description;
}
