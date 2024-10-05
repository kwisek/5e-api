package pl.kwisek.dnd5e.mapper;

import org.junit.jupiter.api.Test;
import pl.kwisek.dnd5e.dto.response.SkillDetailsResponse;
import pl.kwisek.dnd5e.entity.BaseEntity;
import pl.kwisek.dnd5e.entity.SkillEntity;
import pl.kwisek.dnd5e.enumeration.Category;

import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SkillDetailsMapperTest {

    private static final String INDEX_ID = "skill-stealth";
    private static final Category CATEGORY = Category.SKILL;
    private static final String SUB_CATEGORY = "dexterity";
    private static final String NAME = "Stealth";
    private static final String SOURCE = "Player's Handbook";
    private static final String ABILITY = "Dexterity";
    private static final Collection<String> DESCRIPTION = List.of("Description paragraph 1", "Description paragraph 2");
    private final SkillDetailsMapper mapper = new SkillDetailsMapperImpl();

    @Test
    void shouldMapToResponse() {
        // given
        BaseEntity baseEntity = this.createBaseEntity();
        SkillEntity skillEntity = this.createSkillEntity();
        SkillDetailsResponse expected = this.createSkillDetailsResponse();

        // when
        SkillDetailsResponse actual = mapper.toSkillDetailsResponse(baseEntity, skillEntity, DESCRIPTION);

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

    private SkillEntity createSkillEntity() {
        SkillEntity skillEntity = new SkillEntity();
        skillEntity.setAbility(ABILITY);

        return skillEntity;
    }

    private SkillDetailsResponse createSkillDetailsResponse() {
        return new SkillDetailsResponse(
            INDEX_ID,
            CATEGORY,
            SUB_CATEGORY,
            NAME,
            SOURCE,
            ABILITY,
            DESCRIPTION
        );
    }
}
