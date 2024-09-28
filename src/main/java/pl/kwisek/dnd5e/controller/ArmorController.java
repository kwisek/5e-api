package pl.kwisek.dnd5e.controller;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.kwisek.dnd5e.dto.response.ListOfIndexesResponse;
import pl.kwisek.dnd5e.dto.response.ListOfNamesResponse;
import pl.kwisek.dnd5e.service.ArmorService;

@Tag(name="Armor", description = "Operations on Armors")
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/v1/armor", produces = {MediaType.APPLICATION_JSON_VALUE})
public class ArmorController {

    private final ArmorService armorService;

    @ApiResponse(responseCode = "200", description = "Returns a list of all available Armor names.")
    @GetMapping(path = "/names")
    public ResponseEntity<ListOfNamesResponse> getArmorNames() {
        ListOfNamesResponse listOfNamesResponse = armorService.getAllNames();

        return new ResponseEntity<>(listOfNamesResponse, HttpStatus.OK);
    }

    @ApiResponse(responseCode = "200", description = "Returns a list of all available Armor indexes.")
    @GetMapping(path = {"/indexes", "/ids"})
    public ResponseEntity<ListOfIndexesResponse> getArmorIndexes() {
        ListOfIndexesResponse listOfIndexesResponse = armorService.getAllIndexes();

        return new ResponseEntity<>(listOfIndexesResponse, HttpStatus.OK);
    }
}
