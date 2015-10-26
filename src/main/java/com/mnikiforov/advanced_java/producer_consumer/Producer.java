package com.mnikiforov.advanced_java.producer_consumer;

import java.util.Random;

/**
 * Created by sbt-nikiforov-mo on 26.10.15.
 */
public class Producer implements Runnable {
    private Drop drop;

    public Producer(Drop drop) {
        this.drop = drop;
    }

    public void run() {
        String importantInfo[] = {
                "Mares eat oats",
                "Does eat oats",
                "Little lambs eat ivy",
                "A kid will eat ivy too"
        };
        Random random = new Random();

        for (int i = 0; i < importantInfo.length; i++) {
            drop.put(importantInfo[i]);
            System.out.format("MESSAGE SENT(producer): %s%n", importantInfo[i]);
            try {
                Thread.sleep(random.nextInt(4000));
            } catch (InterruptedException e) {
            }
        }
        drop.put("DONE");
    }
}
