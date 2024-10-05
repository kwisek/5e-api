package pl.kwisek.dnd5e.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "BaseEntity")
public class BaseEntity {

    @Id
    @Column(name = "indexId")
    private String indexId;

    @Column(name = "category")
    private String category;

    @Column(name = "subCategory")
    private String subCategory;

    @Column(name = "name")
    private String name;

    @Column(name = "source")
    private String source;
}