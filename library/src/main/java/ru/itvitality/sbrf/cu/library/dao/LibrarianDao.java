package ru.itvitality.sbrf.cu.library.dao;

import ru.itvitality.sbrf.cu.library.entities.Librarian;
import java.util.List;

public interface LibrarianDao {

    void librarianName(Librarian librarianDao);

    List<Librarian> list();
}
