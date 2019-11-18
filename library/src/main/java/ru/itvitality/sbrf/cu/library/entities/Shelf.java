package ru.itvitality.sbrf.cu.library.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "shelf")
public class Shelf {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "nameShelf")
    private String name;

    public Integer getId() {
        return id;
    }

    public Shelf setId(Integer id ) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Shelf setName(String name ) {
        this.name = name;
        return this;
    }

}
