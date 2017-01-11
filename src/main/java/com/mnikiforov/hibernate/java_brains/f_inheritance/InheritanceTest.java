package com.mnikiforov.hibernate.java_brains.f_inheritance;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by zigzzzag on 26.11.15.
 */
public class InheritanceTest {

    public static void main(String[] args) {
        Animal animal = new Animal("AnimalName", "Voice");
        Animal dog = new Dog("DogName", "Gav", "Chappy");
        Animal cat = new Cat("CatName", "May", "Wiskas");

        try (SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory()) {
            try (Session session = sessionFactory.openSession()) {
                session.beginTransaction();
                session.save(animal);
                session.save(dog);
                session.save(cat);
                session.getTransaction().commit();
            }
        }
    }
}
