package pl.kwisek.dnd5e.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "EquipmentPack")
@Data
public class EquipmentPackEntity {
    @Id
    @Column(name = "entityId")
    private String entityId;

    @Column(name = "cost")
    private String cost;

    @Column(name = "weight")
    private String weight;

    @Column(name = "contents")
    private String contents;

    @OneToOne
    @JoinColumn(name = "entityId", insertable = false, updatable = false)
    private BaseEntity baseEntity;
}