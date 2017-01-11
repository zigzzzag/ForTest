package com.mnikiforov.core.multithreading.blocking_queue;

import java.io.File;
import java.util.concurrent.BlockingQueue;

/**
 * Перечисляет все файлы в каталоге и подкаталогах
 * <p>
 * Created by zigzzzag on 12.08.16.
 */
public class FileEnumerationTask implements Runnable {

    public static File DUMMY = new File("");
    private BlockingQueue<File> queue;
    private File startingDirectory;

    /**
     * Конструирует объект типа {@link FileEnumerationTask}
     *
     * @param queue             Блокирующая очередь, в которую вводятся перечисляемые файлы
     * @param startingDirectory Каталог, с которого начинается перечисление файлов
     */
    public FileEnumerationTask(BlockingQueue<File> queue, File startingDirectory) {
        this.queue = queue;
        this.startingDirectory = startingDirectory;
    }

    @Override
    public void run() {
        try {
            enumerate(startingDirectory);
            queue.put(DUMMY);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Рекурсивно перечисляет все файлы в данном каталоге и его подкаталогах
     *
     * @param directory Исходный каталог
     */
    private void enumerate(File directory) throws InterruptedException {
        File[] files = directory.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                enumerate(file);
            } else {
                queue.put(file);
            }
        }
    }
}
