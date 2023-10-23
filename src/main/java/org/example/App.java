package org.example;

import lombok.extern.log4j.Log4j2;

import org.example.utils.Flyway;
import org.example.utils.HibernateUtil;

import org.example.utils.MyOwnRuntimeException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

@Log4j2
final class App {

    private App() {
    }

    public static void main(final String[] args) {
        log.info("Started program");
        new Flyway();

        try (HibernateUtil hibernateUtil = HibernateUtil.getInstance();
             SessionFactory sessionFactory = hibernateUtil.getSessionFactory();
             Session session = sessionFactory.openSession()) {

            log.info("The program is completed");
        } catch (Exception e) {
            throw new MyOwnRuntimeException(e.getMessage());
        }
    }
}

