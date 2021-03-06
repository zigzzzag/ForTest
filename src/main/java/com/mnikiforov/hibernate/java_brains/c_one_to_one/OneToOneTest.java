package com.mnikiforov.hibernate.java_brains.c_one_to_one;

import com.mnikiforov.hibernate.java_brains.common.Vehicle;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by zigzzzag on 12.11.15.
 */
public class OneToOneTest {

    public static void main(String[] args) {
        UserWithOneToOne newUser = new UserWithOneToOne();
        newUser.setUserName("First User");

        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleName("Car");

        newUser.setVehicle(vehicle);


        try (SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory()) {
            try (Session session = sessionFactory.openSession()) {
                session.beginTransaction();
                session.save(newUser);
                session.save(vehicle);
                session.getTransaction().commit();
            }
        }
    }
}
