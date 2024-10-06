package pl.kwisek.dnd5e.mapper;

import org.junit.jupiter.api.Test;
import pl.kwisek.dnd5e.dto.response.ItemDetailsResponse;
import pl.kwisek.dnd5e.entity.BaseEntity;
import pl.kwisek.dnd5e.entity.ItemEntity;
import pl.kwisek.dnd5e.enumeration.Category;

import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ItemDetailsMapperTest {

    private static final String INDEX_ID = "item-healing-potion";
    private static final Category CATEGORY = Category.ITEM;
    private static final String SUB_CATEGORY = "potions";
    private static final String NAME = "Healing Potion";
    private static final String SOURCE = "Player's Handbook";
    private static final String COST = "50 gp";
    private static final String WEIGHT = "0.5 lb.";
    private static final Collection<String> DESCRIPTION = List.of("Description paragraph 1", "Description paragraph 2");
    private final ItemDetailsMapper mapper = new ItemDetailsMapperImpl();

    @Test
    void shouldMapToResponse() {
        // given
        BaseEntity baseEntity = this.createBaseEntity();
        ItemEntity itemEntity = this.createItemEntity();
        ItemDetailsResponse expected = this.createItemDetailsResponse();

        // when
        ItemDetailsResponse actual = mapper.toItemDetailsResponse(baseEntity, itemEntity, DESCRIPTION);

        // then
        assertAll(
                () -> assertEquals(expected.getIndex(), actual.getIndex()),
                () -> assertEquals(expected.getCategory(), actual.getCategory()),
                () -> assertEquals(expected.getSubCategory(), actual.getSubCategory()),
                () -> assertEquals(expected.getName(), actual.getName()),
                () -> assertEquals(expected.getSource(), actual.getSource()),
                () -> assertEquals(expected.getCost(), actual.getCost()),
                () -> assertEquals(expected.getWeight(), actual.getWeight())
        );
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

    private ItemEntity createItemEntity() {
        ItemEntity itemEntity = new ItemEntity();
        itemEntity.setCost(COST);
        itemEntity.setWeight(WEIGHT);

        return itemEntity;
    }

    private ItemDetailsResponse createItemDetailsResponse() {
        return new ItemDetailsResponse(
            INDEX_ID,
            CATEGORY,
            SUB_CATEGORY,
            NAME,
            SOURCE,
            COST,
            WEIGHT,
            DESCRIPTION
        );
    }
}
