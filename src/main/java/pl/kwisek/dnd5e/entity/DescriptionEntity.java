package pl.kwisek.dnd5e.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "Description")
@IdClass(DescriptionId.class)
@Data
public class DescriptionEntity {
    @Id
    @Column(name = "entityId")
    private String entityId;

    @Id
    @Column(name = "textOrder")
    private int textOrder;

    @Column(name = "paragraph")
    private String paragraph;

    @ManyToOne
    @JoinColumn(name = "entityId", insertable = false, updatable = false)
    private BaseEntity baseEntity;
}

@Data
class DescriptionId implements Serializable {
    private String entityId;
    private int textOrder;
}