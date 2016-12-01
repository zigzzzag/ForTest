package com.mnikiforov.hibernate.fetch;

import com.mnikiforov.hibernate.HibernateUtil;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Created by sbt-nikiforov-mo on 12/1/16.
 */
public class FetchTest {

    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        try (Session s = sf.openSession()) {
            Query q = s.createQuery("select o from com.mnikiforov.hibernate.fetch.Org o JOIN FETCH o.accounts as accounts");
            q.setMaxResults(2);

            List<Org> l = q.list();
            System.out.println("first org: " + l);
        }
    }

    private static void addOrg(String orgName) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        try (Session s = sf.openSession()) {
            Org org = new Org(orgName);
            Account acc1 = new Account("111" + orgName);
            Account acc2 = new Account("222" + orgName);
            Account acc3 = new Account("333" + orgName);

            Set<Account> accounts = new HashSet<>();
            accounts.add(acc1);
            accounts.add(acc2);
            accounts.add(acc3);

            org.setAccounts(accounts);

            s.beginTransaction();
            s.save(org);
            s.getTransaction().commit();
        }
    }
}
