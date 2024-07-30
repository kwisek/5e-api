package pl.kwisek.dnd5e.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "SimpleItem")
@Data
public class ItemEntity {
    @Id
    @Column(name = "entityId")
    private String entityId;

    @Column(name = "cost")
    private String cost;

    @Column(name = "weight")
    private String weight;

    @OneToOne
    @JoinColumn(name = "entityId", insertable = false, updatable = false)
    private BaseEntity baseEntity;
}