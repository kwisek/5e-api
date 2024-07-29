package pl.kwisek.dnd5e.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Skill")
public class SkillEntity {
    @Id
    @Column(name = "entityId")
    private String entityId;

    @Column(name = "ability")
    private String ability;

    @OneToOne
    @JoinColumn(name = "entityId", insertable = false, updatable = false)
    private BaseEntity baseEntity;
}