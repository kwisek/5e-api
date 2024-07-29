package pl.kwisek.dnd5e.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Armor")
public class ArmorEntity {
    @Id
    @Column(name = "entityId")
    private String entityId;

    @Column(name = "cost")
    private String cost;

    @Column(name = "weight")
    private String weight;

    @Column(name = "armorClass")
    private String armorClass;

    @Column(name = "strengthRequired")
    private String strengthRequired;

    @Column(name = "stealthDisadvantage")
    private Integer stealthDisadvantage;

    @OneToOne
    @JoinColumn(name = "entityId", insertable = false, updatable = false)
    private BaseEntity baseEntity;
}