package pl.kwisek.dnd5e.mapper;

import org.junit.jupiter.api.Test;
import pl.kwisek.dnd5e.dto.response.EquipmentPackDetailsResponse;
import pl.kwisek.dnd5e.entity.BaseEntity;
import pl.kwisek.dnd5e.entity.EquipmentPackEntity;
import pl.kwisek.dnd5e.enumeration.Category;

import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class EquipmentPackDetailsMapperTest {

    private static final String INDEX_ID = "equipment-pack-explorer";
    private static final Category CATEGORY = Category.EQUIPMENT_PACK;
    private static final String SUB_CATEGORY = "packs";
    private static final String NAME = "Explorer's Pack";
    private static final String SOURCE = "Player's Handbook";
    private static final String COST = "10 gp";
    private static final String WEIGHT = "59 lb.";
    private static final String CONTENTS = "Backpack, Bedroll, Mess Kit, Rations (10 days), Rope (50 feet)";
    private static final List<String> CONTENTS_LIST = List.of("Backpack", "Bedroll", "Mess Kit", "Rations (10 days)", "Rope (50 feet)");
    private static final Collection<String> DESCRIPTION = List.of("Description paragraph 1", "Description paragraph 2");
    private final EquipmentPackDetailsMapper mapper = new EquipmentPackDetailsMapperImpl();

    @Test
    void shouldMapToResponse() {
        // given
        BaseEntity baseEntity = this.createBaseEntity();
        EquipmentPackEntity equipmentPackEntity = this.createEquipmentPackEntity();
        EquipmentPackDetailsResponse expected = this.createEquipmentPackDetailsResponse();

        // when
        EquipmentPackDetailsResponse actual = mapper.toEquipmentPackDetailsResponse(baseEntity, equipmentPackEntity, DESCRIPTION);

        // then
        assertAll(
                () -> assertEquals(expected.getIndex(), actual.getIndex()),
                () -> assertEquals(expected.getCategory(), actual.getCategory()),
                () -> assertEquals(expected.getSubCategory(), actual.getSubCategory()),
                () -> assertEquals(expected.getName(), actual.getName()),
                () -> assertEquals(expected.getSource(), actual.getSource()),
                () -> assertEquals(expected.getCost(), actual.getCost()),
                () -> assertEquals(expected.getWeight(), actual.getWeight()),
                () -> assertEquals(expected.getContents(), actual.getContents())
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

    private EquipmentPackEntity createEquipmentPackEntity() {
        EquipmentPackEntity equipmentPackEntity = new EquipmentPackEntity();
        equipmentPackEntity.setCost(COST);
        equipmentPackEntity.setWeight(WEIGHT);
        equipmentPackEntity.setContents(CONTENTS);

        return equipmentPackEntity;
    }

    private EquipmentPackDetailsResponse createEquipmentPackDetailsResponse() {
        return new EquipmentPackDetailsResponse(
            INDEX_ID,
            CATEGORY,
            SUB_CATEGORY,
            NAME,
            SOURCE,
            COST,
            WEIGHT,
            CONTENTS_LIST,
            DESCRIPTION
        );
    }
}
