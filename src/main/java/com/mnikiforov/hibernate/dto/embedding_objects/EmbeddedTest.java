package com.mnikiforov.hibernate.dto.embedding_objects;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Date;

/**
 * Created by sbt-nikiforov-mo on 12.11.15.
 */
public class EmbeddedTest {

    public static void main(String[] args) {
        UserEmbeddedAddress user1 = new UserEmbeddedAddress();
        user1.setUserName("First User");
        Address homeAddress1 = new Address("home_streetName1", "home_cityName1", "home_stateName1", "home_pincode1");
        user1.setHomeAddress(homeAddress1);
        Address officeAddress1 = new Address("office_streetName1", "office_cityName1", "office_stateName1", "office_pincode1");
        user1.setOfficeAddress(officeAddress1);
        user1.setJoinedDate(new Date());
        user1.setDescription("description here");

        UserEmbeddedAddress user2 = new UserEmbeddedAddress();
        user2.setUserName("Second User");
        Address homeAddress2 = new Address("home_streetName2", "home_cityName2", "home_stateName2", "home_pincode2");
        user2.setHomeAddress(homeAddress2);
        Address officeAddress2 = new Address("office_streetName2", "office_cityName2", "office_stateName2", "office_pincode2");
        user2.setOfficeAddress(officeAddress2);
        user2.setJoinedDate(new Date());
        user2.setDescription("description here");

        try (SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory()) {
            try (Session session = sessionFactory.openSession()) {
                session.beginTransaction();
                session.save(user1);
                session.save(user2);
                session.getTransaction().commit();
            }

            try (Session session = sessionFactory.openSession()) {
                session.beginTransaction();
                UserEmbeddedAddress user = session.get(UserEmbeddedAddress.class, 1);
                System.out.println("User Name retrieved is " + user.getUserName());
            }
        }
    }
}
