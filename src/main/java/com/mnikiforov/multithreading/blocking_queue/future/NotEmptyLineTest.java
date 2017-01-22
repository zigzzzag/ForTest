package com.mnikiforov.multithreading.blocking_queue.future;

import java.io.File;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created by zigzzzag on 18.08.16.
 */
public class NotEmptyLineTest {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter base directory (e.g. /usr/local/jdk5.0/src): ");
        String directory = in.nextLine();

        long start = System.currentTimeMillis();
        Integer countResult;

        LineCounter counter = new LineCounter(new File(directory));
        FutureTask<Integer> task = new FutureTask<>(counter);
        Thread t = new Thread(task);
        t.start();

        ThreadDiagnose diagnose = new ThreadDiagnose(task);
        new Thread(diagnose).start();

        try {
            countResult = task.get();
            System.out.println(countResult + " not empty lines.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("total time: " + (System.currentTimeMillis() - start) + "ms");
    }

    private static class ThreadDiagnose implements Runnable {

        private FutureTask<?> task;

        public ThreadDiagnose(FutureTask<?> task) {
            this.task = task;
        }

        @Override
        public void run() {
            while (!task.isDone()) {
                System.out.println("All thread count: " + Thread.getAllStackTraces().size());

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
