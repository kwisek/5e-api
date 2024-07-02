package pl.kwisek.dnd5e.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@MappedSuperclass
public abstract class BaseEntity {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String name;

    @ElementCollection
    @CollectionTable(name="object_descriptions", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "description")
    private List<String> description;

    @Column(name = "source")
    private String source;
}
