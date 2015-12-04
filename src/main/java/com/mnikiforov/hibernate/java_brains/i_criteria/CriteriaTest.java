package com.mnikiforov.hibernate.java_brains.i_criteria;

import com.mnikiforov.hibernate.java_brains.g_crud.Product;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by sbt-nikiforov-mo on 04.12.15.
 */
public class CriteriaTest {

    public static void main(String[] args) {
        try (SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory()) {
            try (Session session = sessionFactory.openSession()) {
                session.beginTransaction();

                {
                    Criteria criteria = session.createCriteria(Product.class);
                    criteria.add(Restrictions.like("serialNumber", "%serial_number%"))
                            .add(Restrictions.between("id", 3, 6));

                    List<Product> products = criteria.list();
                    for (Product p : products) {
                        System.out.println(p);
                    }
                }

                System.out.println("----------------------------------------------------------------");

                {
                    Criteria criteria = session.createCriteria(Product.class);
                    criteria.add(Restrictions.and(Restrictions.between("id", 2, 7),
                            Restrictions.between("id", 5, 9)));

                    List<Product> products = criteria.list();
                    for (Product p : products) {
                        System.out.println(p);
                    }
                }

                session.getTransaction().commit();
            }
        }
    }
}
