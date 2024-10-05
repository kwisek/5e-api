package pl.kwisek.dnd5e.enumeration;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import pl.kwisek.dnd5e.exception.DataIntegrityException;

import java.util.Arrays;

@RequiredArgsConstructor
@Getter
public enum Category {

    ARMOR("Armor"),
    CONCEPT("Concept"),
    CONTAINER("Container"),
    ITEM("SimpleItem"),
    EQUIPMENT_PACK("EquipmentPack"),
    SKILL("Skill"),
    SPELL("Spell"),
    WEAPON("Weapon");

    private final String value;

    public static Category fromValue(String value) {
        return Arrays.stream(Category.values())
                .filter(x -> x.getValue().equals(value))
                .findFirst()
                .orElseThrow(() -> new DataIntegrityException("Value %s not recognized".formatted(value)));
    }
}
