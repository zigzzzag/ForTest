package com.mnikiforov.hibernate.java_brains.h_query_object;

import com.mnikiforov.hibernate.java_brains.g_crud.Product;
import org.apache.commons.lang.StringUtils;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

/**
 * Created by sbt-nikiforov-mo on 01.12.15.
 */
public class QueryObjectTest {

    public static void main(String[] args) {
        try (SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory()) {
            try (Session session = sessionFactory.openSession()) {
                session.beginTransaction();

                Query query = session.createQuery("from Product");
                query.setFirstResult(4);
                query.setMaxResults(3);
                List<Product> products = query.list();

                System.out.println(StringUtils.join(products, System.lineSeparator()));

                session.getTransaction().commit();
            }
        }
    }
}
