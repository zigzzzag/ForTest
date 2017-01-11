package com.mnikiforov.task.ConcurentThread;

import java.util.Iterator;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by zigzzzag on 25.01.16.
 */
public class CTRunner {

    public static final int QUEUE_SIZE = 1000;
    public static final int CONSUMER_COUNT = 4;
    public static final boolean SHOW_TRACE = false;

    public static final ExecutorService EXECUTOR_SERVICE_PRODUCER = Executors.newSingleThreadExecutor();
    public static final ExecutorService EXECUTOR_SERVICE_CONSUMER = Executors.newFixedThreadPool(CONSUMER_COUNT);
    private BlockingQueue<Item> queue = new ArrayBlockingQueue<>(QUEUE_SIZE, true);//must be thread-safe
//    private Queue<Item> queue = new LinkedList<>();


    public static void main(String[] args) throws InterruptedException {
        CTRunner ctRunner = new CTRunner();
        ctRunner.start();
    }

    private void start() throws InterruptedException {
        EXECUTOR_SERVICE_PRODUCER.submit(new Producer(queue));

        Thread.sleep(1000L);


        long timeStart = System.currentTimeMillis();
        Consumer.LAST_OPERATIONS_TIME.addAndGet(timeStart);

        QueueHandler queueHandler = new QueueHandler(queue);
        for (int i = 0; i < CONSUMER_COUNT; i++) {
            EXECUTOR_SERVICE_CONSUMER.submit(new Consumer(queue, queueHandler));
        }

        EXECUTOR_SERVICE_PRODUCER.shutdown();
        EXECUTOR_SERVICE_PRODUCER.awaitTermination(Long.MAX_VALUE, TimeUnit.SECONDS);
        System.err.println("EXECUTOR_SERVICE_PRODUCER shutdown");
        EXECUTOR_SERVICE_CONSUMER.shutdown();
        EXECUTOR_SERVICE_CONSUMER.awaitTermination(Long.MAX_VALUE, TimeUnit.SECONDS);
        System.err.println("EXECUTOR_SERVICE_CONSUMER shutdown");


        System.err.println("total time: " + (System.currentTimeMillis() - timeStart) + "ms");
        System.err.println("COUNT_HANDLED_ITEMS: " + Consumer.COUNT_HANDLED_ITEMS);
//        System.err.println(getQueueDataStr());
    }

    public String getQueueDataStr() {
        StringBuilder sb = new StringBuilder();

        Iterator<Item> it = queue.iterator();
        while (it.hasNext()) {
            Item item = it.next();
            sb.append(item).append("\r\n");
        }
        sb.append("count: ").append(queue.size());

        return sb.toString();
    }

}
