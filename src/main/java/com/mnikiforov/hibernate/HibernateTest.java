package com.mnikiforov.hibernate;

import com.mnikiforov.hibernate.dto.Address;
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
        UserDetails user1 = new UserDetails();
        user1.setUserName("First User");
        Address address1 = new Address("streetName1", "cityName1", "stateName1", "pincode1");
        user1.setAddress(address1);
        user1.setJoinedDate(new Date());
        user1.setDescription("description here");

        UserDetails user2 = new UserDetails();
        user2.setUserName("Second User");
        Address address2 = new Address("streetName2", "cityName2", "stateName2", "pincode2");
        user2.setAddress(address2);
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
                UserDetails user = session.get(UserDetails.class, 1);
                System.out.println("User Name retrieved is " + user.getUserName());
            }
        }
    }
}
