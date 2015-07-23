package com.mnikiforov.advanced_java.multi_thread.semaphor;

import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 * Created by SBT-Nikiforov-MO on 01.07.2015.
 */
public class SemApp {

    public static void main(String[] args) {
        Runnable limitedCall = new Runnable() {
            final Random rand = new Random();
            final Semaphore available = new Semaphore(3);
            int count = 0;

            public void run() {
                int time = rand.nextInt(15);
                int num = count++;

                try {
                    available.acquire();
                    try {
                        System.out.println("Executing " +
                                "long-running action for " +
                                time + " seconds... #" + num);

                        Thread.sleep(time * 1000);

                        System.out.println("Done with #" +
                                num + "!");

                        if (num < 3) {
                            throw new RuntimeException("Gogi exception");
                        }
                    } finally {
                        available.release();
                    }
                } catch (InterruptedException intEx) {
                    intEx.printStackTrace();
                }
            }
        };

        for (int i = 0; i < 10; i++)
            new Thread(limitedCall).start();
    }
}
