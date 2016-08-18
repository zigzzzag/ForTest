package com.mnikiforov.core.multithreading.blocking_queue.future;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * Подсчитывает файлы, содержащие заданное ключевое слово, в каталоге и его подкаталогах
 * <p>
 * Created by sbt-nikiforov-mo on 18.08.16.
 */
public class MatchCounter implements Callable<Integer> {
    private File directory;
    private String keyword;
    private int count;

    public MatchCounter(File directory, String keyword) {
        this.directory = directory;
        this.keyword = keyword;
    }

    @Override
    public Integer call() {
        count = 0;

        File[] files = directory.listFiles();
        List<Future<Integer>> results = new ArrayList<>();

        for (File file : files) {
            if (file.isDirectory()) {
                MatchCounter counter = new MatchCounter(file, keyword);
                FutureTask<Integer> task = new FutureTask<>(counter);
                results.add(task);
                Thread t = new Thread(task);
                t.start();
            } else {
                if (search(file)) count++;
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
     * Осуществляет поиск ключевого слова
     *
     * @param file Файл для поиска ключевого слова
     * @return true, если ключевое слово содержится в файле
     */
    private boolean search(File file) {
        try {
            try (Scanner in = new Scanner(file)) {
                boolean found = false;
                while (!found && in.hasNextLine()) {
                    String line = in.nextLine();
                    if (line.contains(keyword)) found = true;
                }
                return found;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return false;
    }
}
