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
import pl.kwisek.dnd5e.service.SpellService;

@Tag(name="Spell", description = "Operations on Spells")
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/v1/spell", produces = {MediaType.APPLICATION_JSON_VALUE})
public class SpellController {

    private final SpellService spellService;

    @ApiResponse(responseCode = "200", description = "Returns a list of all available Spell names.")
    @GetMapping(path = "/names")
    public ResponseEntity<ListOfNamesResponse> getSpellNames() {
        ListOfNamesResponse listOfNamesResponse = spellService.getAllNames();

        return new ResponseEntity<>(listOfNamesResponse, HttpStatus.OK);
    }

    @ApiResponse(responseCode = "200", description = "Returns a list of all available Spell indexes.")
    @GetMapping(path = {"/indexes", "/ids"})
    public ResponseEntity<ListOfIndexesResponse> getWeaponIndexes() {
        ListOfIndexesResponse listOfIndexesResponse = spellService.getAllIndexes();

        return new ResponseEntity<>(listOfIndexesResponse, HttpStatus.OK);
    }
}
