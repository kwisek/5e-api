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
import pl.kwisek.dnd5e.service.SpellService;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class SpellControllerTest {

    @Mock
    private SpellService spellService;

    @InjectMocks
    private SpellController spellController;

    private static final List<String> SPELL_NAMES = Arrays.asList("Acid Splash", "Blade Ward");
    private static final List<String> SPELL_INDEXES = Arrays.asList("spell-acid-splash", "spell-blade-ward");

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldReturnListOfNames() {

        // given
        ListOfNamesResponse mockResponse = new ListOfNamesResponse(SPELL_NAMES);
        when(spellService.getAllNames()).thenReturn(mockResponse);

        // when
        ResponseEntity<ListOfNamesResponse> response = spellController.getSpellNames();

        // then
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(mockResponse, response.getBody());
    }

    @Test
    void shouldReturnListOfIndexes() {

        // given
        ListOfIndexesResponse mockResponse = new ListOfIndexesResponse(SPELL_INDEXES);
        when(spellService.getAllIndexes()).thenReturn(mockResponse);

        // when
        ResponseEntity<ListOfIndexesResponse> response = spellController.getSpellIndexes();

        // then
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(mockResponse, response.getBody());
    }
}
