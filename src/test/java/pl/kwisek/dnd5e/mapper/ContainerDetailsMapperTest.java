package pl.kwisek.dnd5e.mapper;

import org.junit.jupiter.api.Test;
import pl.kwisek.dnd5e.dto.response.ContainerDetailsResponse;
import pl.kwisek.dnd5e.entity.BaseEntity;
import pl.kwisek.dnd5e.entity.ContainerEntity;
import pl.kwisek.dnd5e.enumeration.Category;

import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ContainerDetailsMapperTest {

    private static final String INDEX_ID = "container-backpack";
    private static final Category CATEGORY = Category.CONTAINER;
    private static final String SUB_CATEGORY = "containers";
    private static final String NAME = "Backpack";
    private static final String SOURCE = "Player's Handbook";
    private static final String COST = "2 gp";
    private static final String WEIGHT = "5 lb.";
    private static final String CAPACITY = "30 lb.";
    private static final Collection<String> DESCRIPTION = List.of("Description paragraph 1", "Description paragraph 2");
    private final ContainerDetailsMapper mapper = new ContainerDetailsMapperImpl();

    @Test
    void shouldMapToResponse() {
        // given
        BaseEntity baseEntity = this.createBaseEntity();
        ContainerEntity containerEntity = this.createContainerEntity();
        ContainerDetailsResponse expected = this.createContainerDetailsResponse();

        // when
        ContainerDetailsResponse actual = mapper.toContainerDetailsResponse(baseEntity, containerEntity, DESCRIPTION);

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

    private ContainerEntity createContainerEntity() {
        ContainerEntity containerEntity = new ContainerEntity();
        containerEntity.setCost(COST);
        containerEntity.setWeight(WEIGHT);
        containerEntity.setCapacity(CAPACITY);

        return containerEntity;
    }

    private ContainerDetailsResponse createContainerDetailsResponse() {
        return new ContainerDetailsResponse(
            INDEX_ID,
            CATEGORY,
            SUB_CATEGORY,
            NAME,
            SOURCE,
            COST,
            WEIGHT,
            CAPACITY,
            DESCRIPTION
        );
    }
}
