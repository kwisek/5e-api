package pl.kwisek.dnd5e.mapper;

import org.junit.jupiter.api.Test;
import pl.kwisek.dnd5e.dto.response.ConceptDetailsResponse;
import pl.kwisek.dnd5e.entity.ConceptEntity;

import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConceptDetailsMapperTest {

    private static final String INDEX_ID = "concept-wizardry";
    private static final String CATEGORY = "magic";
    private static final String SUB_CATEGORY = "wizardry";
    private static final String NAME = "Wizardry";
    private static final String SOURCE = "Player's Handbook";
    private static final Collection<String> DESCRIPTION = List.of("Description paragraph 1", "Description paragraph 2");
    private final ConceptDetailsMapper mapper = new ConceptDetailsMapperImpl();

    @Test
    void shouldMapToResponse() {

        // given
        ConceptEntity conceptEntity = this.createConceptEntity();
        ConceptDetailsResponse expected = this.createConceptDetailsResponse();

        // when
        ConceptDetailsResponse actual = mapper.toConceptDetailsResponse(conceptEntity, DESCRIPTION);

        // then
        assertEquals(expected, actual);
    }

    private ConceptEntity createConceptEntity() {

        ConceptEntity conceptEntity = new ConceptEntity();
        conceptEntity.setIndexId(INDEX_ID);
        conceptEntity.setCategory(CATEGORY);
        conceptEntity.setSubCategory(SUB_CATEGORY);
        conceptEntity.setName(NAME);
        conceptEntity.setSource(SOURCE);

        return conceptEntity;
    }

    private ConceptDetailsResponse createConceptDetailsResponse() {

        return new ConceptDetailsResponse(
            INDEX_ID,
            CATEGORY,
            SUB_CATEGORY,
            NAME,
            SOURCE,
            DESCRIPTION
        );
    }
}
