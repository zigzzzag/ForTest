package com.mnikiforov.advanced_java.multi_thread.countdownlatch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * Created by SBT-Nikiforov-MO on 01.07.2015.
 */
class Race {
    private Random rand = new Random();
    private int distance = 100;

    private List<String> horses = new ArrayList<>();

    public Race(String... names) {
        this.horses.addAll(Arrays.asList(names));
    }

    public void run() throws InterruptedException {
        System.err.println("And the horses are stepping up to the gate...");
        final CountDownLatch start = new CountDownLatch(1);
        final CountDownLatch finish = new CountDownLatch(horses.size());
        final List<String> places = Collections.synchronizedList(new ArrayList<String>());

        for (final String h : horses) {
            System.err.println(h + " stepping up to the gate...");
            new Thread(new Runnable() {
                public void run() {
                    try {
                        start.await();

                        int traveled = 0;
                        while (traveled < distance) {
                            // через 0-2 секунды....
                            Thread.sleep(rand.nextInt(3) * 1000);

                            // ... лошадь проходит дистанцию 0-14 пунктов
                            traveled += rand.nextInt(15);
                            System.err.println(h + " advanced to " + traveled + "!");
                        }
                        finish.countDown();
                        System.err.println(h + " crossed the finish!");
                        places.add(h);
                    } catch (InterruptedException intEx) {
                        System.err.println("ABORTING RACE!!!");
                        intEx.printStackTrace();
                    }
                }
            }).start();
        }

        System.err.println("And... they're off!");
        start.countDown();

        finish.await();
        System.err.println("And we have our winners!");
        System.err.println(places.get(0) + " took the gold...");
        System.err.println(places.get(1) + " got the silver...");
        System.err.println("and " + places.get(2) + " took home the bronze.");
    }

    public int getDistance() {
        return distance;
    }
}

