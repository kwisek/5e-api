package pl.kwisek.dnd5e.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.kwisek.dnd5e.dto.response.ListOfNamesResponse;
import pl.kwisek.dnd5e.dto.response.WeaponDetailsResponse;
import pl.kwisek.dnd5e.service.WeaponService;

@Tag(name="Weapons", description = "Operations on Weapons")
@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping(path = "/weapons", produces = {MediaType.APPLICATION_JSON_VALUE})
public class WeaponController {

    @Autowired
    private final WeaponService weaponService;

    @ApiResponse(responseCode = "200", description = "Returns a list of all available Weapon names.")
    @GetMapping(path = "/names")
    public ResponseEntity<ListOfNamesResponse> getWeaponNames() {
        ListOfNamesResponse listOfNamesResponse = weaponService.getWeaponNames();

        return new ResponseEntity<>(listOfNamesResponse, HttpStatus.OK);
    }

    @ApiResponse(responseCode = "200", description = "Returns details of Weapon identified by provided index.")
    @GetMapping(path = "")
    public ResponseEntity<WeaponDetailsResponse> getWeaponDetails(@RequestParam(required = true) String index) {
        return new ResponseEntity<>(weaponService.getWeaponDetails(index), HttpStatus.OK);
    }
}
