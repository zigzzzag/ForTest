package com.mnikiforov.hibernate;

import com.mnikiforov.hibernate.dto.UserDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Date;

/**
 * Created by sbt-nikiforov-mo on 12.11.15.
 */
public class HibernateTest {

    public static void main(String[] args) {
        UserDetails user = new UserDetails();
        user.setId(1);
        user.setUserName("First User");
        user.setAddress("First users`s address");
        user.setJoinedDate(new Date());
        user.setDescription("description here");

        try (SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory()) {
            try (Session session = sessionFactory.openSession()) {
                session.beginTransaction();
                session.save(user);
                session.getTransaction().commit();
            }

            try (Session session = sessionFactory.openSession()) {
                session.beginTransaction();
                user = session.get(UserDetails.class, 1);
                System.out.println("User Name retrieved is " + user.getUserName());
            }
        }


    }
}
