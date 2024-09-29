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
import pl.kwisek.dnd5e.service.ItemService;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class ItemControllerTest {

    @Mock
    private ItemService itemService;

    @InjectMocks
    private ItemController itemController;

    private static final List<String> ITEM_NAMES = Arrays.asList("Abacud", "Acid");
    private static final List<String> ITEM_INDEXES = Arrays.asList("item-abacud", "item-acid");

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldReturnListOfNames() {

        // given
        ListOfNamesResponse mockResponse = new ListOfNamesResponse(ITEM_NAMES);
        when(itemService.getAllNames()).thenReturn(mockResponse);

        // when
        ResponseEntity<ListOfNamesResponse> response = itemController.getItemNames();

        // then
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(mockResponse, response.getBody());
    }

    @Test
    void shouldReturnListOfIndexes() {

        // given
        ListOfIndexesResponse mockResponse = new ListOfIndexesResponse(ITEM_INDEXES);
        when(itemService.getAllIndexes()).thenReturn(mockResponse);

        // when
        ResponseEntity<ListOfIndexesResponse> response = itemController.getItemIndexes();

        // then
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(mockResponse, response.getBody());
    }
}
