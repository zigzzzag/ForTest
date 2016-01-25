package com.mnikiforov.task.ConcurentThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by sbt-nikiforov-mo on 25.01.16.
 */
public class CTRunner {

    public static final ExecutorService EXECUTOR_SERVICE = Executors.newFixedThreadPool(4);

    public static void main(String[] args) throws InterruptedException {
        ExternalProcess.INSTANCE.setQueue(ExternalData.INSTANCE.getQueue());


        for (int i = 0; i < 10; i++) {
            EXECUTOR_SERVICE.submit(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 50; j++) {
                        ExternalProcess.INSTANCE.addRandomItem();
                        try {
                            Thread.sleep(10L);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        }

        EXECUTOR_SERVICE.shutdown();
        EXECUTOR_SERVICE.awaitTermination(Long.MAX_VALUE, TimeUnit.SECONDS);

        System.out.println(ExternalData.INSTANCE.getQueueDataStr());
    }
}
