package com.mnikiforov.advanced_java.producer_consumer;

import java.util.Random;

/**
 * Created by sbt-nikiforov-mo on 26.10.15.
 */
public class Consumer implements Runnable {

    private Drop drop;

    public Consumer(Drop drop) {
        this.drop = drop;
    }

    public void run() {
        Random random = new Random();
        for (String message = drop.take(); !message.equals("DONE"); message = drop.take()) {
            System.out.format("MESSAGE RECEIVED(consumer): %s%n", message);
            try {
                Thread.sleep(random.nextInt(10_000));
            } catch (InterruptedException e) {
            }
        }
    }
}
