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

    @Schema(description = "Unique index, format: equipmentpack-X.", example = "equipmentpack-priests-pack")
    private String index;

    @Schema(description = "Category. For this schema, always will be set to 'EquipmentPack'.", example = "EquipmentPack")
    private Category category;

    @Schema(description = "Subcategory of an Equipment Pack. Currently there are no subcategories, so will always be set to 'EquipmentPack'.", example = "EquipmentPack")
    private String subCategory;

    @Schema(description = "Exact name.", example = "Priest's Pack")
    private String name;

    @Schema(description = "Source. Entities are mostly originating from Player's Handbook.", example = "Player's Handbook")
    private String source;

    @Schema(description = "Value, format: '___,___ _p'. Possible currencies are: pp, gp, sp, cp.", example = "19 gp")
    private String cost;

    @Schema(description = "Weight in lbs, format: '_ lb.'", example = "-")
    private String weight;

    @ArraySchema(schema = @Schema(description = "Content, described as a collection of strings.", example = "10 candles"))
    private Collection<String> contents;

    @ArraySchema(schema = @Schema(description = "Description paragraph"))
    private Collection<String> description;
}
