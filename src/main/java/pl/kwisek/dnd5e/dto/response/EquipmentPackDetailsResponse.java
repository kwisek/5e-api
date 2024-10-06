package pl.kwisek.dnd5e.dto.response;

import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import pl.kwisek.dnd5e.enumeration.Category;

import java.util.Collection;

@AllArgsConstructor
@Getter
public class EquipmentPackDetailsResponse extends BaseEntityResponse {

    @Schema(example = "equipmentpack-priests-pack")
    private String index;

    @Schema(example = "EquipmentPack")
    private Category category;

    @Schema(example = "EquipmentPack")
    private String subCategory;

    @Schema(example = "Priest's Pack")
    private String name;

    @Schema(example = "Player's Handbook")
    private String source;

    @Schema(example = "19 gp")
    private String cost;

    @Schema(example = "-")
    private String weight;

    @ArraySchema(schema = @Schema(example = "10 candles"))
    private Collection<String> contents;

    @ArraySchema(schema = @Schema(example = ""))
    private Collection<String> description;
}
