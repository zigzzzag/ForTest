package com.mnikiforov.hibernate.dto.b_collections;

import com.mnikiforov.hibernate.dto.User;
import com.mnikiforov.hibernate.dto.a_embedding_objects.Address;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by sbt-nikiforov-mo on 12.11.15.
 */
public class CollectionsTest {

    public static void main(String[] args) {
        UserWithCollection newUser = new UserWithCollection();
        newUser.setUserName("First User");

        Address address1 = new Address("address 1", "city 1", "state 1", "100001");
        Address address2 = new Address("address 2", "city 2", "state 2", "200002");
        newUser.getListOfAddresses().add(address1);
        newUser.getListOfAddresses().add(address2);

        try (SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory()) {
            try (Session session = sessionFactory.openSession()) {
                session.beginTransaction();
                session.save(newUser);
                session.getTransaction().commit();
            }

            try (Session session = sessionFactory.openSession()) {
                session.beginTransaction();
                UserWithCollection user = session.get(UserWithCollection.class, 1);
                session.close();
                System.out.println(user.getListOfAddresses().size());
            }
        }
    }
}
