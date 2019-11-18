package ru.itvitality.sbrf.cu.library.dao;

import ru.itvitality.sbrf.cu.library.entities.Book;

import java.util.List;

public interface BookDao {

    void addBook(Book book);

    List<Book> list();

}
