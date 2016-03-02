package com.mnikiforov.trash.sber.multi_thread_file.custom_file;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by sbt-nikiforov-mo on 02.03.16.
 */
public class CustoFileTest {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        final CountDownLatch start = new CountDownLatch(1);
        for (int i = 0; i < 3; i++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
//                    try {
//                        start.await();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }

                    File file = new File("targetFile");
                    System.err.println(file.getAbsolutePath());
                    try {
                        FileOutputStream fos = new FileOutputStream(file);
                        try {
                            for (int i = 0; i < 10; i++) {
                                fos.write((i + " " + Thread.currentThread().getName() + "\n").getBytes());
                            }
                        } finally {
                            fos.flush();
                            fos.close();
                        }
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            });
            Thread.sleep(1000);
        }

        start.countDown();

        executorService.shutdown();
        executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS);

        File file = new File("targetFile");
        System.err.println(file.getAbsolutePath());
        try {
            FileOutputStream fos = new FileOutputStream(file);
            try {
                for (int i = 0; i < 3; i++) {
                    fos.write((i + " " + Thread.currentThread().getName() + "\n").getBytes());
                }
            } finally {
                fos.flush();
                fos.close();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
