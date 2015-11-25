package com.mnikiforov.hibernate.dto.e_many_to_many;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by sbt-nikiforov-mo on 12.11.15.
 */
public class ManyToManyTest {

    public static void main(String[] args) {
        UserWithManyToMany firstUser = new UserWithManyToMany();
        firstUser.setUserName("First User");
        UserWithManyToMany secondUser = new UserWithManyToMany();
        secondUser.setUserName("Second User");

        Girl firstGirl = new Girl();
        firstGirl.setName("First Girl");
        Girl secondGirl = new Girl();
        secondGirl.setName("First Girl");

        firstUser.getGirls().add(firstGirl);
        secondUser.getGirls().add(firstGirl);
        secondUser.getGirls().add(secondGirl);

        firstGirl.getMans().add(firstUser);
        firstGirl.getMans().add(secondUser);
        secondGirl.getMans().add(secondUser);

        try (SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory()) {
            try (Session session = sessionFactory.openSession()) {
                session.beginTransaction();
                session.save(firstUser);
                session.save(secondUser);
                session.save(firstGirl);
                session.save(secondGirl);
                session.getTransaction().commit();
            }
        }
    }
}
