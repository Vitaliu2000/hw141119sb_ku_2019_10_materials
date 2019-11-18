package ru.itvitality.sbrf.cu.library.dao;

import ru.itvitality.sbrf.cu.library.entities.Shelf;

import java.util.List;

public interface ShelfDao {

    void lookShelf(Shelf shelf);

    List<Shelf> list();

}
