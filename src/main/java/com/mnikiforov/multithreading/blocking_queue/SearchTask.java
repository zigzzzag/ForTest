package com.mnikiforov.multithreading.blocking_queue;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;

/**
 * Осуществляет поиск заданного ключевого слова
 * <p>
 * Created by zigzzzag on 12.08.16.
 */
public class SearchTask implements Runnable {

    BlockingQueue<File> queue;
    String keyword;

    /**
     * Конструирует объект {@link SearchTask}
     *
     * @param queue   Очередь, из которой извлекаются файлы
     * @param keyword Ключевое слово
     */
    public SearchTask(BlockingQueue<File> queue, String keyword) {
        this.queue = queue;
        this.keyword = keyword;
    }

    @Override
    public void run() {
        try {
            boolean done = false;
            while (!done) {
                File file = queue.take();
                if (file == FileEnumerationTask.DUMMY) {
                    queue.put(file);
                    done = true;
                } else {
                    search(file);
                }
            }
        } catch (InterruptedException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Осуществляет поиск в файле заданного ключевого слова и выводит все строки, содержащие это слово
     *
     * @param file Файл для поиска ключевого слова
     */
    private void search(File file) throws FileNotFoundException {
        try (Scanner in = new Scanner(file)) {
            int lineNumber = 0;
            while (in.hasNextLine()) {
                lineNumber++;
                String line = in.nextLine();
                if (line.contains(keyword)) {
                    System.out.printf("%s:%d:%s%n", file.getPath(), lineNumber, line);
                }
            }
        }
    }
}
