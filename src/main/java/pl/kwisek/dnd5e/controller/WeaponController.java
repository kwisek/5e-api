package pl.kwisek.dnd5e.controller;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.kwisek.dnd5e.dto.response.ListOfIndexesResponse;
import pl.kwisek.dnd5e.dto.response.ListOfNamesResponse;
import pl.kwisek.dnd5e.service.WeaponService;

@Tag(name="Weapon", description = "Operations on Weapons")
@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping(path = "/weapon", produces = {MediaType.APPLICATION_JSON_VALUE})
public class WeaponController {

    @Autowired
    private final WeaponService weaponService;

    @ApiResponse(responseCode = "200", description = "Returns a list of all available Weapon names.")
    @GetMapping(path = "/names")
    public ResponseEntity<ListOfNamesResponse> getWeaponNames() {
        ListOfNamesResponse listOfNamesResponse = weaponService.getAllNames();

        return new ResponseEntity<>(listOfNamesResponse, HttpStatus.OK);
    }

    @ApiResponse(responseCode = "200", description = "Returns a list of all available Weapon indexes.")
    @GetMapping(path = {"/indexes", "/ids"})
    public ResponseEntity<ListOfIndexesResponse> getWeaponIndexes() {
        ListOfIndexesResponse listOfIndexesResponse = weaponService.getAllIndexes();

        return new ResponseEntity<>(listOfIndexesResponse, HttpStatus.OK);
    }
}
