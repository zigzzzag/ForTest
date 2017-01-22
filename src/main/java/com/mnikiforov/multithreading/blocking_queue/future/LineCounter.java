package com.mnikiforov.multithreading.blocking_queue.future;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import org.apache.commons.lang.StringUtils;

/**
 * Подсчитывает файлы, содержащие заданное ключевое слово, в каталоге и его подкаталогах
 * <p>
 * Created by zigzzzag on 18.08.16.
 */
public class LineCounter implements Callable<Integer> {
    private File directory;
    private int count;

    public LineCounter(File directory) {
        this.directory = directory;
    }

    @Override
    public Integer call() {
        count = 0;

        File[] files = directory.listFiles();
        List<Future<Integer>> results = new ArrayList<>();

        for (File file : files) {
            if (file.isDirectory()) {
                LineCounter counter = new LineCounter(file);
                FutureTask<Integer> task = new FutureTask<>(counter);
                results.add(task);
                Thread t = new Thread(task);
                t.start();
            } else {
                count += getNotEmptyLineCount(file);
            }
        }

        for (Future<Integer> result : results) {
            try {
                count += result.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

        return count;
    }

    /**
     * Считает количество непустых строк в файле
     *
     * @param file Файл для подсчета строк
     * @return Количество непустых строк в файле
     */
    private int getNotEmptyLineCount(File file) {
        int countLine = 0;
        try {
            try (Scanner in = new Scanner(file)) {
                while (in.hasNextLine()) {
                    String line = in.nextLine();
                    if (StringUtils.isNotBlank(line)) {
                        countLine++;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return countLine;
    }
}
