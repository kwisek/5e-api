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
import pl.kwisek.dnd5e.service.ContainerService;

@Tag(name="Container", description = "Operations on Containers")
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/v1/container", produces = {MediaType.APPLICATION_JSON_VALUE})
public class ContainerController {

    private final ContainerService containerService;

    @ApiResponse(responseCode = "200", description = "Returns a list of all available Container names.")
    @GetMapping(path = "/names")
    public ResponseEntity<ListOfNamesResponse> getContainerNames() {
        ListOfNamesResponse listOfNamesResponse = containerService.getAllNames();

        return new ResponseEntity<>(listOfNamesResponse, HttpStatus.OK);
    }

    @ApiResponse(responseCode = "200", description = "Returns a list of all available Container indexes.")
    @GetMapping(path = {"/indexes", "/ids"})
    public ResponseEntity<ListOfIndexesResponse> getContainerIndexes() {
        ListOfIndexesResponse listOfIndexesResponse = containerService.getAllIndexes();

        return new ResponseEntity<>(listOfIndexesResponse, HttpStatus.OK);
    }
}
