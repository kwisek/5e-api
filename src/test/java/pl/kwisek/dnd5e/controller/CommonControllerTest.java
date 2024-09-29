package pl.kwisek.dnd5e.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import pl.kwisek.dnd5e.dto.response.BaseEntityResponse;
import pl.kwisek.dnd5e.dto.response.ListOfIndexesResponse;
import pl.kwisek.dnd5e.dto.response.ListOfNamesResponse;
import pl.kwisek.dnd5e.service.CommonService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.Arrays;

public class CommonControllerTest {

    @InjectMocks
    private CommonController commonController;

    @Mock
    private CommonService commonService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void shouldReturnAllNames() {

        // given
        ListOfNamesResponse mockResponse = new ListOfNamesResponse(Arrays.asList("Longsword", "Acid splash"));
        when(commonService.getAllNames()).thenReturn(mockResponse);

        // when
        ResponseEntity<ListOfNamesResponse> response = commonController.getAllNames();

        // then
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(mockResponse, response.getBody());
    }

    @Test
    public void shouldReturnAllIndexes() {

        // given
        ListOfIndexesResponse mockResponse = new ListOfIndexesResponse(Arrays.asList("weapon-longsword", "armor-chainmail"));
        when(commonService.getAllIndexes()).thenReturn(mockResponse);

        // when
        ResponseEntity<ListOfIndexesResponse> response = commonController.getAllIndexes();

        // then
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(mockResponse, response.getBody());
    }

    @Test
    public void shouldReturnEntityDetails() {

        // given
        String index = "weapon-longsword";
        BaseEntityResponse mockResponse = mock(BaseEntityResponse.class);
        when(commonService.getDetails(index)).thenReturn(mockResponse);

        // when
        ResponseEntity<? extends BaseEntityResponse> response = commonController.getEntityDetails(index);

        // then
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(mockResponse, response.getBody());
    }

    @Test
    public void shouldReturnClosestEntityDetails() {

        // given
        String name = "longsword";
        BaseEntityResponse mockResponse = mock(BaseEntityResponse.class);
        when(commonService.getDetailsOfClosestMatch(name)).thenReturn(mockResponse);

        // when
        ResponseEntity<? extends BaseEntityResponse> response = commonController.getClosestEntityDetails(name);

        // then
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(mockResponse, response.getBody());
    }
}
