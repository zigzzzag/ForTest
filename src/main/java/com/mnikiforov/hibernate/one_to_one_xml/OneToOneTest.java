package com.mnikiforov.hibernate.one_to_one_xml;

import com.mnikiforov.hibernate.HibernateUtil;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;

/**
 * Created by sbt-nikiforov-mo on 11/16/16.
 */
public class OneToOneTest {

    public static void main(String[] args) {
        System.out.println("Hibernate one to one (XML mapping)");
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
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
            } catch (RuntimeException e) {
                session.getTransaction().rollback();
                System.err.println("RuntimeException: transaction rollback!");
                throw e;
            }

            List<Stock> stocks = session.createQuery("from Stock").list();
            for (Stock s : stocks) {
                System.out.println(s);
            }
        } finally {
            session.close();
            HibernateUtil.getSessionFactory().close();
        }
    }
}
