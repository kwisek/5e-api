package pl.kwisek.dnd5e.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Value;

@Value
public class SpellComponentsSection {
    @Schema(description = "Verbal component required", example = "true")
    Boolean V;

    @Schema(description = "Semantic component required", example = "true")
    Boolean S;

    @Schema(description = "Material component required", example = "true")
    Boolean M;

    @Schema(description = "Material component (empty string if not required)", example = "An eggshell and a snakeskin glove")
    String material;
}