package com.mnikiforov.ehcache.perfomance;

import com.mnikiforov.hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

class GenerateTestData {

    private static final Logger LOG = LoggerFactory.getLogger(GenerateTestData.class);
    private static final int ENTRY_COUNT = 2_000_000;
    private static final int BATCH_SIZE = 50;

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        try (SessionFactory sessionFactory = HibernateUtil.getSessionFactory()) {
            try (Session session = sessionFactory.openSession()) {
                session.beginTransaction();

                for (int i = 0; i < ENTRY_COUNT; i++) {
                    PerformanceCache p = new PerformanceCache()
                            .name("First Name " + i)
                            .type("First Type " + i)
                            .data1("First data1 " + i)
                            .data2("First data2 " + i)
                            .data3("First data3 " + i)
                            .data4("First data4 " + i)
                            .data5("First data5 " + i)
                            .shelfLife(new Date());
                    session.save(p);

                    if (i % BATCH_SIZE == 0) {
                        session.flush();
                        session.clear();
                        LOG.info("flushing: {}", i);
                    }
                }

                session.getTransaction().commit();
            }
        }

        LOG.info("Total time {}ms", System.currentTimeMillis() - startTime);
    }
}
