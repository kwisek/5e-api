package pl.kwisek.dnd5e.dto.request;

import io.swagger.v3.oas.annotations.Parameter;
import lombok.Value;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Value
public class WeaponRequest {
    @Parameter(description = "Weapon id", example = "weapon-longsword")
    @Size(min = 1, max = 128, message = "Id must be between 1 and 128 characters long")
    @Pattern(regexp = "^[a-z-]+$", message = "Id must only contain lowercase letters and dashes")
    String id;
}
