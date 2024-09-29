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
import pl.kwisek.dnd5e.service.WeaponService;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class WeaponControllerTest {

    @Mock
    private WeaponService weaponService;

    @InjectMocks
    private WeaponController weaponController;

    private static final List<String> WEAPON_NAMES = Arrays.asList("Dagger", "Longsword");
    private static final List<String> WEAPON_INDEXES = Arrays.asList("weapon-dagger", "weapon-longsword");

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldReturnListOfNames() {

        // given
        ListOfNamesResponse mockResponse = new ListOfNamesResponse(WEAPON_NAMES);
        when(weaponService.getAllNames()).thenReturn(mockResponse);

        // when
        ResponseEntity<ListOfNamesResponse> response = weaponController.getWeaponNames();

        // then
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(mockResponse, response.getBody());
    }

    @Test
    void shouldReturnListOfIndexes() {

        // given
        ListOfIndexesResponse mockResponse = new ListOfIndexesResponse(WEAPON_INDEXES);
        when(weaponService.getAllIndexes()).thenReturn(mockResponse);

        // when
        ResponseEntity<ListOfIndexesResponse> response = weaponController.getWeaponIndexes();

        // then
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(mockResponse, response.getBody());
    }
}
