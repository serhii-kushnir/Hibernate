package org.example.services.planet;

import org.example.entity.Planet;
import org.example.utils.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public final class PlanetCrudServiceImpl implements PlanetCrudService {

    private final SessionFactory sessionFactory = HibernateUtil.getInstance().getSessionFactory();

    @Override
    public void create(final Planet planet) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(planet);
            transaction.commit();
        }
    }

    @Override
    public Planet read(final String id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Planet.class, id);
        }
    }

    @Override
    public void update(final Planet planet) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.merge(planet);
            transaction.commit();
        }
    }

    @Override
    public void delete(final Planet planet) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.remove(planet);
            transaction.commit();
        }
    }
}
