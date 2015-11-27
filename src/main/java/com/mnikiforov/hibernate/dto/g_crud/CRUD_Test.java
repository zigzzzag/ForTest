package com.mnikiforov.hibernate.dto.g_crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by sbt-nikiforov-mo on 27.11.15.
 */
public class CRUD_Test {

    public static void main(String[] args) {
//        try (SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory()) {
//            try (Session session = sessionFactory.openSession()) {
//                session.beginTransaction();
//
//                for (int i = 0; i < 10; i++) {
//                    Product product = new Product("serial_number_" + i);
//                    session.save(product);
//                }
//
//                session.getTransaction().commit();
//            }
//        }

//        try (SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory()) {
//            try (Session session = sessionFactory.openSession()) {
//                session.beginTransaction();
//
//                int id = 6;
//                Product product = getProductById(session, id);
//                System.out.println("product with id = " + id + " have serial number: " + product.getSerialNumber());
//
//                session.getTransaction().commit();
//            }
//        }

//        try (SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory()) {
//            try (Session session = sessionFactory.openSession()) {
//                session.beginTransaction();
//
//                int id = 6;
//                Product product = getProductById(session, id);
//                session.delete(product);
//
//                session.getTransaction().commit();
//            }
//        }

        try (SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory()) {
            try (Session session = sessionFactory.openSession()) {
                session.beginTransaction();

                int id = 5;
                Product product = getProductById(session, id);
                product.setSerialNumber("updated_serialnumber");
                session.update(product);

                session.getTransaction().commit();
            }
        }
    }

    private static Product getProductById(Session session, int id) {
        return session.get(Product.class, id);
    }
}
