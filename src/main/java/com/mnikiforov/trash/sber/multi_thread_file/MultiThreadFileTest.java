package com.mnikiforov.trash.sber.multi_thread_file;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;

/**
 * Created by zigzzzag on 02.03.16.
 */
public class MultiThreadFileTest implements Runnable {

    private static final String TIME_FORMAT = "mm:ss.SSS";
    private static final String DATA = "Hello Sberbank!\nHello Sberbank!\nHello Sberbank!\nHello Sberbank!\nHello Sberbank!\n" +
            "Hello Sberbank!\nHello Sberbank!\nHello Sberbank!\nHello Sberbank!\nHello Sberbank!\nHello Sberbank!\n" +
            "Hello Sberbank!\nHello Sberbank!\nHello Sberbank!\nHello Sberbank!\nHello Sberbank!\nHello Sberbank!\n" +
            "Hello Sberbank!\nHello Sberbank!\nHello Sberbank!\nHello Sberbank!\nHello Sberbank!\nHello Sberbank!\n" +
            "Hello Sberbank!\nHello Sberbank!\nHello Sberbank!\nHello Sberbank!\nHello Sberbank!\nHello Sberbank!\n" +
            "Hello Sberbank!\nHello Sberbank!\nHello Sberbank!\nHello Sberbank!\nHello Sberbank!\nHello Sberbank!\n";
    public static final String exportPath = "/media/sbt-nikiforov-mo/Repository/trash/test/";

    private CountDownLatch start;

    Realization realization;

    public MultiThreadFileTest(Realization realization, CountDownLatch start) {
        this.realization = realization;
        this.start = start;
    }

    @Override
    public void run() {
        try {
            start.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        System.err.println(getStartMessage());

        File targetFile = null;
        try {
            targetFile = realization.gitUniqueFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

//        System.err.println(getFinishMessage(targetFile));

        try {
            FileOutputStream fos = new FileOutputStream(targetFile, true);
            try {
                fos.write(DATA.getBytes());
            } finally {
                fos.close();
            }
            Thread.sleep(500);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private String getStartMessage() {
        return Thread.currentThread().getName() + " " + realization.getName() + " start time: "
                + new SimpleDateFormat(TIME_FORMAT).format(new Date());
    }

    private String getFinishMessage(File targetFile) {
        return Thread.currentThread().getName() + " " + realization.getName() + " get file: "
                + targetFile.getName();
    }


    private static final int THREAD_COUNT = 50;
    private static final int TASK_COUNT = 200;

    public static void main(String[] args) throws InterruptedException, IOException {
        FileUtils.cleanDirectory(new File(exportPath));

        Realization oldRealization = new OldRealization();
        Realization patchRealization = new PatchRealization();
        Realization newRealization = new NewRealization();

//        Realization oldRealization = new OldRealization();
//        Realization patchRealization = new OldRealization();
//        Realization newRealization = new OldRealization();

        /** old **/
        long oldTime = startTestInCourse(oldRealization);
        /** patch **/
        long patchTime = startTestInCourse(patchRealization);
        /** new **/
        long newTime = startTestInCourse(newRealization);


        FileUtils.cleanDirectory(new File(exportPath));
        long allTime = startTestAllAtOnce(oldRealization, patchRealization, newRealization);


        System.err.println("oldTime:   " + oldTime + "ms");
        System.err.println("patchTime: " + patchTime + "ms");
        System.err.println("newTime:   " + newTime + "ms");
        System.err.println("allTime:   " + allTime + "ms");
    }

    private static long startTestInCourse(Realization realization) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_COUNT);
        CountDownLatch start = new CountDownLatch(1);
        for (int i = 0; i < TASK_COUNT; i++) {
            executorService.submit(new MultiThreadFileTest(realization, start));
        }

        long startTime = System.currentTimeMillis();
        start.countDown();
        executorService.shutdown();
        executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS);

        return System.currentTimeMillis() - startTime;
    }

    private static long startTestAllAtOnce(Realization... realizations) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_COUNT);
        CountDownLatch start = new CountDownLatch(1);
        for (int i = 0; i < TASK_COUNT; i++) {
            executorService.submit(new MultiThreadFileTest(realizations[0], start));
            executorService.submit(new MultiThreadFileTest(realizations[1], start));
            executorService.submit(new MultiThreadFileTest(realizations[2], start));
        }

        long startTime = System.currentTimeMillis();
        start.countDown();
        executorService.shutdown();
        executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS);

        return System.currentTimeMillis() - startTime;
    }
}
