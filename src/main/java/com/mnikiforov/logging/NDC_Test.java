package com.mnikiforov.logging;


import java.util.HashSet;
import java.util.Set;
import org.apache.log4j.NDC;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Created by zigzzzag on 25.08.16.
 */
public class NDC_Test {

    private static final Logger LOG = LoggerFactory.getLogger(NDC_Test.class);

    public static void main(String[] args) throws InterruptedException {
        Set<Thread> allThreads = new HashSet<>();

        LOG.info("Start without NDC");
        for (int i = 0; i < 3; i++) {
            final int finalI = i;
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 3; j++) {
                        try {
                            LOG.info("{} run {}", Thread.currentThread().getName(), finalI);
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
            allThreads.add(t);
            t.start();
        }
        for (Thread t : allThreads) {
            t.join();
        }
        LOG.info("Finish without NDC\n");
        allThreads.clear();


        LOG.info("Start with NDC");
        for (int i = 0; i < 3; i++) {
            final int finalI = i;
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    NDC.push(Thread.currentThread().getName() + " push message");
                    try {
                        for (int j = 0; j < 3; j++) {
                            LOG.info("{} run {}", Thread.currentThread().getName(), finalI);
                            Thread.sleep(500);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        NDC.pop();
                        LOG.info("finally");
                    }
                }
            });
            t.start();
            allThreads.add(t);
        }
        for (Thread t : allThreads) {
            t.join();
        }
        LOG.info("Finish with NDC\n");
    }
}
