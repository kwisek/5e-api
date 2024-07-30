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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.kwisek.dnd5e.dto.response.BaseEntityResponse;
import pl.kwisek.dnd5e.dto.response.ListOfIndexesResponse;
import pl.kwisek.dnd5e.dto.response.ListOfNamesResponse;
import pl.kwisek.dnd5e.service.ConceptService;

@Tag(name="Concept", description = "Operations on Concepts")
@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping(path = "/concept", produces = {MediaType.APPLICATION_JSON_VALUE})
public class ConceptController {
    @Autowired
    ConceptService commonService;

    @ApiResponse(responseCode = "200", description = "Returns a list of all available names.")
    @GetMapping(path = "/names")
    public ResponseEntity<ListOfNamesResponse> getAllNames() {
        ListOfNamesResponse listOfNamesResponse = commonService.getAllNames();

        return new ResponseEntity<>(listOfNamesResponse, HttpStatus.OK);
    }

    @ApiResponse(responseCode = "200", description = "Returns a list of all available indexes.")
    @GetMapping(path = "/indexes")
    public ResponseEntity<ListOfIndexesResponse> getAllIndexes() {
        ListOfIndexesResponse listOfIndexesResponse = commonService.getAllIndexes();

        return new ResponseEntity<>(listOfIndexesResponse, HttpStatus.OK);
    }

    @ApiResponse(responseCode = "200", description = "Returns details of Entity identified by provided index.")
    @GetMapping(path = "/details")
    public ResponseEntity<? extends BaseEntityResponse> getEntityDetails(@RequestParam(required = true) String index) {
        return new ResponseEntity<>(commonService.getDetails(index), HttpStatus.OK);
    }
}
