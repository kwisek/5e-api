package pl.kwisek.dnd5e.dto.response;

import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.kwisek.dnd5e.enumeration.Category;

import java.util.Collection;

// hidden in SwaggerConfig
@Schema(oneOf = {
            ArmorDetailsResponse.class,
            ConceptDetailsResponse.class,
            ContainerDetailsResponse.class,
            EquipmentPackDetailsResponse.class,
            ItemDetailsResponse.class,
            SkillDetailsResponse.class,
            SpellDetailsResponse.class,
            WeaponDetailsResponse.class
})
@NoArgsConstructor
@Getter @Setter
public class BaseEntityResponse {

    @Schema(description = "Unique index, format: category-X", example = "armor-plate")
    private String index;

    @Schema(description = "Main category of an entity", example = "Armor")
    private Category category;

    @Schema(description = "Subcategory of an entity.", example = "Heavy Armor")
    private String subCategory;

    @Schema(description = "Exact name of an entity.", example = "Plate")
    private String name;

    @Schema(description = "Source. Entities are mostly originating from Player's Handbook.", example = "Player's Handbook")
    private String source;

    @ArraySchema(schema = @Schema(description = "Description paragraph"))
    private Collection<String> description;
}
