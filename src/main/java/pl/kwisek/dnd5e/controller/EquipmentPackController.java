package pl.kwisek.dnd5e.controller;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.kwisek.dnd5e.dto.response.ListOfIndexesResponse;
import pl.kwisek.dnd5e.dto.response.ListOfNamesResponse;
import pl.kwisek.dnd5e.service.EquipmentPackService;

@Tag(name="Container", description = "Operations on Equipment packs")
@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping(path = "/v1/equipmentpack", produces = {MediaType.APPLICATION_JSON_VALUE})
public class EquipmentPackController {

    @Autowired
    private final EquipmentPackService equipmentPackService;

    @ApiResponse(responseCode = "200", description = "Returns a list of all available Equipment pack names.")
    @GetMapping(path = "/names")
    public ResponseEntity<ListOfNamesResponse> getEquipmentPackNames() {
        ListOfNamesResponse listOfNamesResponse = equipmentPackService.getAllNames();

        return new ResponseEntity<>(listOfNamesResponse, HttpStatus.OK);
    }

    @ApiResponse(responseCode = "200", description = "Returns a list of all available Equipment pack indexes.")
    @GetMapping(path = {"/indexes", "/ids"})
    public ResponseEntity<ListOfIndexesResponse> getEquipmentPackIndexes() {
        ListOfIndexesResponse listOfIndexesResponse = equipmentPackService.getAllIndexes();

        return new ResponseEntity<>(listOfIndexesResponse, HttpStatus.OK);
    }
}
