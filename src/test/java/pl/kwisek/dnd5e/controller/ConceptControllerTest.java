package pl.kwisek.dnd5e.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import pl.kwisek.dnd5e.dto.response.ListOfIndexesResponse;
import pl.kwisek.dnd5e.dto.response.ListOfNamesResponse;
import pl.kwisek.dnd5e.service.ConceptService;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class ConceptControllerTest {

    @Mock
    private ConceptService conceptService;

    @InjectMocks
    private ConceptController conceptController;

    private static final List<String> CONCEPT_NAMES = Arrays.asList("Magic", "Stealth");
    private static final List<String> CONCEPT_INDEXES = Arrays.asList("concept-magic", "concept-stealth");

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldReturnListOfNames() {

        // given
        ListOfNamesResponse mockResponse = new ListOfNamesResponse(CONCEPT_NAMES);
        when(conceptService.getAllNames()).thenReturn(mockResponse);

        // when
        ResponseEntity<ListOfNamesResponse> response = conceptController.getAllNames();

        // then
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(mockResponse, response.getBody());
    }

    @Test
    void shouldReturnListOfIndexes() {

        // given
        ListOfIndexesResponse mockResponse = new ListOfIndexesResponse(CONCEPT_INDEXES);
        when(conceptService.getAllIndexes()).thenReturn(mockResponse);

        // when
        ResponseEntity<ListOfIndexesResponse> response = conceptController.getAllIndexes();

        // then
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(mockResponse, response.getBody());
    }
}
