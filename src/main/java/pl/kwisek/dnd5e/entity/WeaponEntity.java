package pl.kwisek.dnd5e.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "Weapon")
public class WeaponEntity extends BaseEntity {

    @Column(name = "damage_roll")
    private String damageRoll;

    @Column(name = "damage_type")
    private String damageType;

    @ElementCollection
    @CollectionTable(name="weapon_property", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "description")
    private List<String> properties;

    @Column(name = "weight")
    private String weight;

    @Column(name = "value")
    private String value;

    @Column(name = "category")
    private String category;
}
