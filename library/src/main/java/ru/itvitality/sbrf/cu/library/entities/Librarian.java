package ru.itvitality.sbrf.cu.library.entities;

import javax.persistence.*;

@Entity
@Table(name = "librarian")
public class Librarian {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "nameLibrarian")
    private String name;

    public Integer getId() {
        return id;
    }

    public Librarian setId(Integer id ) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Librarian setName(String name ) {
        this.name = name;
        return this;
    }

}
