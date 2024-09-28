package pl.kwisek.dnd5e.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Table;
import jakarta.persistence.OneToOne;
import jakarta.persistence.JoinColumn;
import lombok.Data;

@Entity
@Data
@Table(name = "Spell")
public class SpellEntity {

    @Id
    @Column(name = "entityId")
    private String entityId;

    @Column(name = "requiredComponentV")
    private Integer requiredComponentV;

    @Column(name = "requiredComponentS")
    private Integer requiredComponentS;

    @Column(name = "requiredComponentM")
    private Integer requiredComponentM;

    @Column(name = "requiredMaterial")
    private String requiredMaterial;

    @Column(name = "level")
    private Integer level;

    @Column(name = "range")
    private String range;

    @Column(name = "school")
    private String school;

    @Column(name = "duration")
    private String duration;

    @Column(name = "requiredRitual")
    private Integer requiredRitual;

    @Column(name = "castingTime")
    private String castingTime;

    @Column(name = "classes")
    private String classes;

    @Column(name = "higherLevel")
    private String higherLevel;

    @OneToOne
    @JoinColumn(name = "entityId", insertable = false, updatable = false)
    private BaseEntity baseEntity;
}

