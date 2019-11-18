package ru.itvitality.sbrf.cu.library.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import ru.itvitality.sbrf.cu.library.dao.BookDao;
import ru.itvitality.sbrf.cu.library.entities.Book;

import java.util.List;

public class BookDaoImpl implements BookDao {

    private final SessionFactory sessionFactory;

    public BookDaoImpl() {
        Configuration configuration = new Configuration()
                .configure( "hibernate.cfg.xml" );

        StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings( configuration.getProperties() ).build();

        Metadata metadata = new MetadataSources( serviceRegistry )
                .addAnnotatedClass( Book.class )
                .getMetadataBuilder()
                .build();
        sessionFactory = metadata.getSessionFactoryBuilder().build();
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

    @Override
    public void addBook(Book book) {
        try ( Session session = sessionFactory.openSession() ) {
            session.beginTransaction();
            session.save( book );
            System.out.println( ">>>>>>>>>>> created:" + book );

            System.out.println( ">>>>>>>>>>> before commit" );
            session.getTransaction().commit();

            // А тут select не выполняется, Book берется из кэша L1
            Book selected = session.get( Book.class, book.getId() );
            System.out.println( ">>>>>>>>>>> selected:" + selected );
        }
    }

    @Override
    public List<Book> list() {
        try ( Session session = sessionFactory.openSession() ) {
            return session.createQuery( "select u from Book u", Book.class ).list();

        }
    }
}







