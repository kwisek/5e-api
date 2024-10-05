package pl.kwisek.dnd5e.service;

import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import pl.kwisek.dnd5e.dto.response.BaseEntityResponse;
import pl.kwisek.dnd5e.dto.response.ListOfIndexesResponse;
import pl.kwisek.dnd5e.dto.response.ListOfNamesResponse;
import pl.kwisek.dnd5e.dto.response.WeaponDetailsResponse;
import pl.kwisek.dnd5e.entity.BaseEntity;
import pl.kwisek.dnd5e.entity.WeaponEntity;
import pl.kwisek.dnd5e.enumeration.Category;
import pl.kwisek.dnd5e.mapper.WeaponDetailsMapper;
import pl.kwisek.dnd5e.repo.BaseEntityRepository;
import pl.kwisek.dnd5e.repo.DescriptionRepository;
import pl.kwisek.dnd5e.repo.WeaponRepository;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CommonServiceImplTest {

    @Mock
    private BaseEntityRepository baseEntityRepository;

    @Mock
    private WeaponDetailsMapper weaponDetailsMapper;

    @Mock
    private WeaponRepository weaponRepository;

    @Mock
    private DescriptionRepository descriptionRepository;

    @InjectMocks
    private CommonServiceImpl commonService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldReturnAllNames() {

        // given
        Collection<String> names = List.of("Sword", "Shield");
        when(baseEntityRepository.getAllNames()).thenReturn(names);

        // when
        ListOfNamesResponse response = commonService.getAllNames();

        // then
        assertEquals(names, response.getNames());
        verify(baseEntityRepository).getAllNames();
    }

    @Test
    void shouldReturnAllIndexes() {

        // given
        Collection<String> indexes = List.of("weapon_sword", "weapon_shield");
        when(baseEntityRepository.getAllIndexes()).thenReturn(indexes);

        // when
        ListOfIndexesResponse response = commonService.getAllIndexes();

        // then
        assertEquals(indexes, response.getIndexes());
        verify(baseEntityRepository).getAllIndexes();
    }

    @Test
    void shouldReturnEntityDetails() {

        // given
        String index = "weapon-dagger";
        Category category = Category.WEAPON;

        // mock entities
        WeaponEntity weaponEntity = mock(WeaponEntity.class);
        BaseEntity baseEntity = mock(BaseEntity.class);
        Collection<String> description = Collections.emptyList();

        when(baseEntity.getIndexId()).thenReturn(index);
        when(baseEntity.getCategory()).thenReturn(category.getValue());

        when(baseEntityRepository.findByIndex(index)).thenReturn(Optional.of(baseEntity));
        when(weaponRepository.findByIndex(index)).thenReturn(Optional.of(weaponEntity));
        when(descriptionRepository.findByIndex(index)).thenReturn(description);

        // mock mapping
        WeaponDetailsResponse expectedResponse = mock(WeaponDetailsResponse.class);
        when(weaponDetailsMapper.toWeaponDetailsResponse(baseEntity, weaponEntity, description)).thenReturn(expectedResponse);

        // when
        BaseEntityResponse response = commonService.getDetails(index);

        // then
        assertNotNull(response);
        assertEquals(expectedResponse, response);
        verify(baseEntityRepository).findByIndex(index);
        verify(weaponRepository).findByIndex(index);
        verify(descriptionRepository).findByIndex(index);
    }

    @Test
    void shouldFailReturningEntityDetailsWhenThereIsNoMatch() {

        // given
        String index = "non_existing_index";
        when(baseEntityRepository.findByIndex(index)).thenReturn(Optional.empty());

        // when
        EntityNotFoundException thrown = assertThrows(EntityNotFoundException.class, () -> {
            commonService.getDetails(index);
        });

        // then
        assertEquals("No entity matches index: " + index, thrown.getMessage());
    }

    @Test
    void shouldReturnDetailsOfClosestMatchWhenEntityIsFound() {
        // given
        String queryName = "Sword";
        String closestName = "Longsword";
        String closestIndex = "weapon-longsword";
        Category closestCategory = Category.WEAPON;

        // mock entities
        WeaponEntity weaponEntity = mock(WeaponEntity.class);
        BaseEntity closestBaseEntity = mock(BaseEntity.class);
        Collection<String> description = Collections.emptyList();

        when(closestBaseEntity.getCategory()).thenReturn(closestCategory.getValue());
        when(closestBaseEntity.getIndexId()).thenReturn(closestIndex);

        // mock repositories
        when(baseEntityRepository.getAllNames()).thenReturn(List.of(closestName));
        when(baseEntityRepository.findByName(closestName)).thenReturn(Optional.of(closestBaseEntity));
        when(weaponRepository.findByIndex(closestBaseEntity.getIndexId())).thenReturn(Optional.of(weaponEntity));
        when(descriptionRepository.findByIndex(closestBaseEntity.getIndexId())).thenReturn(description);

        // mock mapping
        WeaponDetailsResponse expectedResponse = mock(WeaponDetailsResponse.class);
        when(weaponDetailsMapper.toWeaponDetailsResponse(closestBaseEntity, weaponEntity, description)).thenReturn(expectedResponse);

        // when
        BaseEntityResponse response = commonService.getDetailsOfClosestMatch(queryName);

        // then
        assertNotNull(response);
        assertEquals(expectedResponse, response);
        verify(baseEntityRepository).getAllNames();
        verify(baseEntityRepository).findByName(closestName);
        verify(weaponRepository).findByIndex(closestIndex);
        verify(descriptionRepository).findByIndex(closestIndex);
    }
}
