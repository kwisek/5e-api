package pl.kwisek.dnd5e.mapper;

import org.junit.jupiter.api.Test;
import pl.kwisek.dnd5e.dto.response.ArmorDetailsResponse;
import pl.kwisek.dnd5e.entity.ArmorEntity;
import pl.kwisek.dnd5e.entity.BaseEntity;
import pl.kwisek.dnd5e.enumeration.Category;

import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ArmorDetailsMapperTest {

    private static final String INDEX_ID = "armor-chainmail";
    private static final Category CATEGORY = Category.ARMOR;
    private static final String SUB_CATEGORY = "Heavy armor";
    private static final String NAME = "Chainmail";
    private static final String SOURCE = "Player's Handbook";
    private static final String COST = "75 gp";
    private static final String WEIGHT = "55 lb.";
    private static final String ARMOR_CLASS = "16";
    private static final String STR_REQUIRED = "Str 13";
    private static final Integer STEALTH_DISADVANTAGE = 1;
    private static final Collection<String> DESCRIPTION = List.of("Description paragraph 1", "Description paragraph 2");
    private final ArmorDetailsMapper mapper = new ArmorDetailsMapperImpl();

    @Test
    void shouldMapToResponse() {
        // given
        BaseEntity baseEntity = this.createBaseEntity();
        ArmorEntity armorEntity = this.createArmorEntity();
        ArmorDetailsResponse expected = this.createArmorDetailsResponse();

        // when
        ArmorDetailsResponse actual = mapper.toArmorDetailsResponse(baseEntity, armorEntity, DESCRIPTION);

        // then
        assertEquals(expected, actual);
    }

    private BaseEntity createBaseEntity() {
        BaseEntity baseEntity = new BaseEntity();
        baseEntity.setIndexId(INDEX_ID);
        baseEntity.setCategory(CATEGORY.getValue());
        baseEntity.setSubCategory(SUB_CATEGORY);
        baseEntity.setName(NAME);
        baseEntity.setSource(SOURCE);

        return baseEntity;
    }

    private ArmorEntity createArmorEntity() {
        ArmorEntity armorEntity = new ArmorEntity();
        armorEntity.setCost(COST);
        armorEntity.setWeight(WEIGHT);
        armorEntity.setArmorClass(ARMOR_CLASS);
        armorEntity.setStrengthRequired(STR_REQUIRED);
        armorEntity.setStealthDisadvantage(STEALTH_DISADVANTAGE);

        return armorEntity;
    }

    private ArmorDetailsResponse createArmorDetailsResponse() {
        return new ArmorDetailsResponse(
            INDEX_ID,
            CATEGORY,
            SUB_CATEGORY,
            NAME,
            SOURCE,
            COST,
            WEIGHT,
            ARMOR_CLASS,
            STR_REQUIRED,
            (STEALTH_DISADVANTAGE != 0),
            DESCRIPTION
        );
    }
}