package ru.itvitality.sbrf.cu.library.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import ru.itvitality.sbrf.cu.library.dao.ShelfDao;
import ru.itvitality.sbrf.cu.library.entities.Shelf;

import java.util.List;

public class ShelfDaoImpl implements ShelfDao {

    private final SessionFactory sessionFactory;

    public ShelfDaoImpl() {
        Configuration configuration = new Configuration()
                .configure( "hibernate.cfg.xml" );

        StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings( configuration.getProperties() ).build();

        Metadata metadata = new MetadataSources( serviceRegistry )
                .addAnnotatedClass( Shelf.class )
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
    public void lookShelf(Shelf book) {

    }

    @Override
    public List<Shelf> list() {
        try ( Session session = sessionFactory.openSession() ) {
            return session.createQuery( "select u from Shelf u", Shelf.class ).list();

        }
    }
}
