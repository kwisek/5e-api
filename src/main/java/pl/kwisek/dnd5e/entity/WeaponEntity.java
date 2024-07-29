package pl.kwisek.dnd5e.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "Weapon")
public class WeaponEntity {
    @Id
    @Column(name = "entityId")
    private String entityId;

    @Column(name = "cost")
    private String cost;

    @Column(name = "weight")
    private String weight;

    @Column(name = "damageType")
    private String damageType;

    @Column(name = "damageRoll")
    private String damageRoll;

    @Column(name = "properties")
    private String properties;

    @OneToOne
    @JoinColumn(name = "entityId", insertable = false, updatable = false)
    private BaseEntity baseEntity;
}