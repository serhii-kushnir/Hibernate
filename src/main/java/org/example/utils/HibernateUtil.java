package org.example.utils;

import lombok.Getter;
import lombok.extern.log4j.Log4j2;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@Log4j2
@Getter
public final class HibernateUtil implements AutoCloseable {
    private static final HibernateUtil INSTANCE;
    private final SessionFactory sessionFactory;

    static {
        try {
            log.info("Start initializing HibernateUtil");
            INSTANCE = new HibernateUtil();

            log.info("HibernateUtil initialized successfully");
        } catch (Exception e) {
            log.error("Failed to initialize HibernateUtil", e);
            throw new HibernateInitializationException("Failed to initialize HibernateUtil", e);
        }
    }

    private HibernateUtil() {
        try {
            log.info("Initialize SessionFactory");
            sessionFactory = new Configuration()
//                    .addAnnotatedClass(Person.class)
//                    .addAnnotatedClass(Address.class)
//                    .addAnnotatedClass(Contact.class)
                    .buildSessionFactory();
        } catch (Exception e) {
            throw new HibernateInitializationException("Failed to build SessionFactory", e);
        }
    }

    public static HibernateUtil getInstance() {
        return INSTANCE;
    }

    @Override
    public void close() {
        sessionFactory.close();
        log.info("Close SessionFactory");
    }
}