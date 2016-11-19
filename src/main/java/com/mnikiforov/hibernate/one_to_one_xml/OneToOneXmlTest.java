package com.mnikiforov.hibernate.one_to_one_xml;

import com.mnikiforov.hibernate.HibernateUtil;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Created by sbt-nikiforov-mo on 11/16/16.
 */
public class OneToOneXmlTest {

    public static void main(String[] args) {
        System.out.println("Hibernate one to one (XML mapping)");

        try (SessionFactory sessionFactory = HibernateUtil.getSessionFactory()) {
            try (Session session = sessionFactory.openSession()) {
                try {
                    session.beginTransaction();

                    Stock stock = new Stock();
                    stock.setStockCode("4716");
                    stock.setStockName("GENM2");

                    StockDetail stockDetail = new StockDetail();
                    stockDetail.setCompName("GENTING Malaysia");
                    stockDetail.setCompDesc("Best resort in the world");
                    stockDetail.setRemark("Nothing Special");
                    stockDetail.setListedDate(new Date());

                    stock.setStockDetail(stockDetail);
                    stockDetail.setStock(stock);

                    session.save(stock);
                    session.getTransaction().commit();
                    System.out.println("Done");
                } catch (RuntimeException ex) {
                    session.getTransaction().rollback();
                    System.err.println("RuntimeException: transaction rollback!");
                    throw ex;
                }
            }

            try (Session session = sessionFactory.openSession()) {
                List<Stock> stocks = session.createQuery("from Stock").list();
                for (Stock s : stocks) {
                    System.out.println(s);
                }
            }
        }
    }
}
