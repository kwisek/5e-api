package pl.kwisek.dnd5e.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.kwisek.dnd5e.dto.request.WeaponRequest;
import pl.kwisek.dnd5e.dto.response.WeaponResponse;
import pl.kwisek.dnd5e.service.WeaponService;

import javax.validation.Valid;

@Tag(name="Weapons", description = "Operations on Weapons")
@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping(path = "/weapons", produces = {MediaType.APPLICATION_JSON_VALUE})
public class WeaponController {

    @Autowired
    private final WeaponService weaponService;

    @Operation(summary = "Returns a Weapon-type object associated with the provided id.")
    @ApiResponse(responseCode = "200", description = "Returns a Weapon-type object associated with the provided id.")
    @GetMapping(path = "")
    public ResponseEntity<WeaponResponse> getWeaponById(@Valid @ParameterObject WeaponRequest weaponRequest) {
        WeaponResponse weaponResponse = weaponService.getWeaponById(weaponRequest.getId());
        return new ResponseEntity<>(weaponResponse, HttpStatus.OK);
    }
}
