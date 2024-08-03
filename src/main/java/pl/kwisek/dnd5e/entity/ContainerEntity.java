package pl.kwisek.dnd5e.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Container")
@Data
public class ContainerEntity {
    @Id
    @Column(name = "entityId")
    private String entityId;

    @Column(name = "cost")
    private String cost;

    @Column(name = "weight")
    private String weight;

    @Column(name = "capacity")
    private String capacity;

    @OneToOne
    @JoinColumn(name = "entityId", insertable = false, updatable = false)
    private BaseEntity baseEntity;
}