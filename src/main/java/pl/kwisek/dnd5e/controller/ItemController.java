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
import pl.kwisek.dnd5e.service.ItemService;

@Tag(name="Item", description = "Operations on Items")
@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping(path = "/item", produces = {MediaType.APPLICATION_JSON_VALUE})
public class ItemController {

    @Autowired
    private final ItemService itemService;

    @ApiResponse(responseCode = "200", description = "Returns a list of all available Item names.")
    @GetMapping(path = "/names")
    public ResponseEntity<ListOfNamesResponse> getItemNames() {
        ListOfNamesResponse listOfNamesResponse = itemService.getAllNames();

        return new ResponseEntity<>(listOfNamesResponse, HttpStatus.OK);
    }

    @ApiResponse(responseCode = "200", description = "Returns a list of all available Item indexes.")
    @GetMapping(path = {"/indexes", "/ids"})
    public ResponseEntity<ListOfIndexesResponse> getItemIndexes() {
        ListOfIndexesResponse listOfIndexesResponse = itemService.getAllIndexes();

        return new ResponseEntity<>(listOfIndexesResponse, HttpStatus.OK);
    }
}
