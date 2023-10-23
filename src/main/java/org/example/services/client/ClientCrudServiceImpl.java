package org.example.services.client;

import org.example.entity.Client;
import org.example.utils.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public final class ClientCrudServiceImpl implements ClientCrudService {
    private final SessionFactory sessionFactory = HibernateUtil.getInstance().getSessionFactory();

    @Override
    public void create(final Client client) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(client);
            transaction.commit();
        }
    }

    @Override
    public Client read(final Long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Client.class, id);
        }
    }

    @Override
    public void update(final Client client) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.merge(client);
            transaction.commit();
        }
    }

    @Override
    public void delete(final Client client) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.remove(client);
            transaction.commit();
        }
    }
}
