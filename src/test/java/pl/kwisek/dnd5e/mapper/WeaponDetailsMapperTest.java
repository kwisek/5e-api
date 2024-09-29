package pl.kwisek.dnd5e.mapper;

import org.junit.jupiter.api.Test;
import pl.kwisek.dnd5e.dto.response.WeaponDetailsResponse;
import pl.kwisek.dnd5e.entity.BaseEntity;
import pl.kwisek.dnd5e.entity.WeaponEntity;

import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WeaponDetailsMapperTest {

    private static final String INDEX_ID = "weapon-longsword";
    private static final String CATEGORY = "Weapon";
    private static final String SUB_CATEGORY = "Martial Melee Weapons";
    private static final String NAME = "Longsword";
    private static final String SOURCE = "Player's Handbook";
    private static final String COST = "15 gp";
    private static final String WEIGHT = "3 lb.";
    private static final String DAMAGE_TYPE = "Slashing";
    private static final String DAMAGE_ROLL = "1d8";
    private static final String PROPERTIES = "Versatile";
    private static final Collection<String> DESCRIPTION = List.of("Description paragraph 1", "Description paragraph 2");
    private static final List<String> PROPERTIES_LIST = List.of("Versatile");

    private final WeaponDetailsMapper mapper = new WeaponDetailsMapperImpl();

    @Test
    void shouldMapToResponse() {

        // given
        BaseEntity baseEntity = this.createBaseEntity();
        WeaponEntity weaponEntity = this.createWeaponEntity();
        WeaponDetailsResponse expected = this.createWeaponDetailsResponse();

        // when
        WeaponDetailsResponse actual = mapper.toWeaponDetailsResponse(baseEntity, weaponEntity, DESCRIPTION);

        // then
        assertEquals(expected, actual);
    }

    private BaseEntity createBaseEntity() {

        BaseEntity baseEntity = new BaseEntity();
        baseEntity.setIndexId(INDEX_ID);
        baseEntity.setCategory(CATEGORY);
        baseEntity.setSubCategory(SUB_CATEGORY);
        baseEntity.setName(NAME);
        baseEntity.setSource(SOURCE);

        return baseEntity;
    }

    private WeaponEntity createWeaponEntity() {

        WeaponEntity weaponEntity = new WeaponEntity();
        weaponEntity.setCost(COST);
        weaponEntity.setWeight(WEIGHT);
        weaponEntity.setDamageType(DAMAGE_TYPE);
        weaponEntity.setDamageRoll(DAMAGE_ROLL);
        weaponEntity.setProperties(PROPERTIES);

        return weaponEntity;
    }

    private WeaponDetailsResponse createWeaponDetailsResponse() {

        return new WeaponDetailsResponse(
            INDEX_ID,
            CATEGORY,
            SUB_CATEGORY,
            NAME,
            SOURCE,
            COST,
            WEIGHT,
            DAMAGE_TYPE,
            DAMAGE_ROLL,
            PROPERTIES_LIST,
            DESCRIPTION
        );
    }
}
