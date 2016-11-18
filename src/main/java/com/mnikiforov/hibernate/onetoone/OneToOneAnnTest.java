package com.mnikiforov.hibernate.onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

/**
 * Created by Zigzag on 19.11.2016.
 */
public class OneToOneAnnTest {

    public static void main(String[] args) {
        try (SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory()) {
            try (Session session = sessionFactory.openSession()) {
                session.beginTransaction();

                Passport p = new Passport("2343");

                User u = new User("user2");
                u.setPassport(p);

                session.save(u);
                session.getTransaction().commit();
            }

            try (Session session = sessionFactory.openSession()) {
                List<User> users = session.createQuery("from User").list();
//                for (User u : users) {
//                    System.out.println(u);
//                }
            }
        }
    }
}
