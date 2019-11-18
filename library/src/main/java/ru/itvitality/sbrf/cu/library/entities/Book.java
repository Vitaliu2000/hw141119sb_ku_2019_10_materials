package ru.itvitality.sbrf.cu.library.entities;

import javax.persistence.*;

@Entity
@Table(name = "BookName")
public class Book {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "name")
    private String name;

    public Integer getId() {
        return id;
    }

    public Book setId(Integer id ) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Book setName(String name ) {
        this.name = name;
        return this;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
