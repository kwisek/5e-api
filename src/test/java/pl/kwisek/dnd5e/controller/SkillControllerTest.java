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
import pl.kwisek.dnd5e.service.SkillService;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class SkillControllerTest {

    @Mock
    private SkillService skillService;

    @InjectMocks
    private SkillController skillController;

    private static final List<String> SKILL_NAMES = Arrays.asList("Athletics", "Acrobatics");
    private static final List<String> SKILL_INDEXES = Arrays.asList("skill-athletics", "skill-acrobatics");

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldReturnListOfNames() {

        // given
        ListOfNamesResponse mockResponse = new ListOfNamesResponse(SKILL_NAMES);
        when(skillService.getAllNames()).thenReturn(mockResponse);

        // when
        ResponseEntity<ListOfNamesResponse> response = skillController.getSkillNames();

        // then
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(mockResponse, response.getBody());
    }

    @Test
    void shouldReturnListOfIndexes() {

        // given
        ListOfIndexesResponse mockResponse = new ListOfIndexesResponse(SKILL_INDEXES);
        when(skillService.getAllIndexes()).thenReturn(mockResponse);

        // when
        ResponseEntity<ListOfIndexesResponse> response = skillController.getSkillIndexes();

        // then
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(mockResponse, response.getBody());
    }
}
