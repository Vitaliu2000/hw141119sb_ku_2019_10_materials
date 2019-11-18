package ru.itvitality.sbrf.cu.library.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import ru.itvitality.sbrf.cu.library.dao.LibrarianDao;
import ru.itvitality.sbrf.cu.library.entities.Librarian;

import java.util.List;

public class LibrarianDaoImpl implements LibrarianDao {

    private final SessionFactory sessionFactory;

    public LibrarianDaoImpl() {
        Configuration configuration = new Configuration()
                .configure( "hibernate.cfg.xml" );

        StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings( configuration.getProperties() ).build();

        Metadata metadata = new MetadataSources( serviceRegistry )
                .addAnnotatedClass( Librarian.class )
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
    public void librarianName(Librarian librarian) {
    }

    @Override
    public List<Librarian> list() {
        try ( Session session = sessionFactory.openSession() ) {
            return session.createQuery( "select u from Librarian u", Librarian.class ).list();

        }
    }
}
