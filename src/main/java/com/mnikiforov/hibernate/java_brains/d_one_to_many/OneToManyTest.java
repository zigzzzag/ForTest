package com.mnikiforov.hibernate.java_brains.d_one_to_many;

import com.mnikiforov.hibernate.java_brains.common.Vehicle;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by sbt-nikiforov-mo on 12.11.15.
 */
public class OneToManyTest {

    public static void main(String[] args) {
        UserWithOneToMany newUser = new UserWithOneToMany();
        newUser.setUserName("First User");

        Vehicle vehicle1 = new Vehicle();
        vehicle1.setVehicleName("Car");
        Vehicle vehicle2 = new Vehicle();
        vehicle2.setVehicleName("Jeep");

        newUser.getVehicle().add(vehicle1);
        newUser.getVehicle().add(vehicle2);

        vehicle1.setUserMTO(newUser);
        vehicle2.setUserMTO(newUser);

        try (SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory()) {
            try (Session session = sessionFactory.openSession()) {
                session.beginTransaction();
                session.persist(newUser);
//                session.save(newUser);
//                session.save(vehicle1);
//                session.save(vehicle2);
                session.getTransaction().commit();
            }
        }
    }
}
