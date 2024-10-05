package pl.kwisek.dnd5e.mapper;

import org.junit.jupiter.api.Test;
import pl.kwisek.dnd5e.dto.SpellComponentsSection;
import pl.kwisek.dnd5e.dto.response.SpellDetailsResponse;
import pl.kwisek.dnd5e.entity.BaseEntity;
import pl.kwisek.dnd5e.entity.SpellEntity;
import pl.kwisek.dnd5e.enumeration.Category;

import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SpellDetailsMapperTest {

    private static final String INDEX_ID = "spell-fireball";
    private static final Category CATEGORY = Category.SPELL;
    private static final String SUB_CATEGORY = "Evocation";
    private static final String NAME = "Fireball";
    private static final String SOURCE = "Player's Handbook";
    private static final Integer LEVEL = 3;
    private static final String RANGE = "150 feet";
    private static final String SCHOOL = "Evocation";
    private static final String DURATION = "Instantaneous";
    private static final Boolean RITUAL = false;
    private static final String CASTING_TIME = "1 action";
    private static final String HIGHER_LEVEL = "Higher level description";
    private static final Collection<String> DESCRIPTION = List.of("Description paragraph 1", "Description paragraph 2");
    private static final String CLASSES = "Wizard, Sorcerer";
    private static final List<String> CLASSES_LIST = List.of("Wizard", "Sorcerer");
    private static final Boolean COMPONENT_V = true;
    private static final Boolean COMPONENT_S = true;
    private static final Boolean COMPONENT_M = true;
    private static final String MATERIAL = "Material description";

    private final SpellDetailsMapper mapper = new SpellDetailsMapperImpl();

    @Test
    void shouldMapToResponse() {
        // given
        BaseEntity baseEntity = this.createBaseEntity();
        SpellEntity spellEntity = this.createSpellEntity();
        SpellDetailsResponse expected = this.createSpellDetailsResponse();

        // when
        SpellDetailsResponse actual = mapper.toSpellDetailsResponse(baseEntity, spellEntity, DESCRIPTION);

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

    private SpellEntity createSpellEntity() {
        SpellEntity spellEntity = new SpellEntity();
        spellEntity.setLevel(LEVEL);
        spellEntity.setRange(RANGE);
        spellEntity.setSchool(SCHOOL);
        spellEntity.setDuration(DURATION);
        spellEntity.setRequiredRitual(RITUAL ? 1 : 0);
        spellEntity.setCastingTime(CASTING_TIME);
        spellEntity.setHigherLevel(HIGHER_LEVEL);
        spellEntity.setClasses(CLASSES);
        spellEntity.setRequiredComponentV(COMPONENT_V ? 1 : 0);
        spellEntity.setRequiredComponentS(COMPONENT_S ? 1 : 0);
        spellEntity.setRequiredComponentM(COMPONENT_M ? 1 : 0);
        spellEntity.setRequiredMaterial(MATERIAL);

        return spellEntity;
    }

    private SpellDetailsResponse createSpellDetailsResponse() {
        SpellComponentsSection components = new SpellComponentsSection(COMPONENT_V, COMPONENT_S, COMPONENT_M, MATERIAL);

        return new SpellDetailsResponse(
            INDEX_ID,
            CATEGORY,
            SUB_CATEGORY,
            NAME,
            SOURCE,
            components,
            LEVEL,
            RANGE,
            SCHOOL,
            DURATION,
            RITUAL,
            CASTING_TIME,
            CLASSES_LIST,
            HIGHER_LEVEL,
            DESCRIPTION
        );
    }
}
