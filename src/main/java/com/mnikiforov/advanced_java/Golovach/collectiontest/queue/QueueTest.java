package com.mnikiforov.advanced_java.Golovach.collectiontest.queue;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by zigzzzag on 19.06.2015.
 */
public class QueueTest {

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        fillQueue(queue);
        printQueue(queue, "queue");

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        fillQueue(priorityQueue);
        printQueue(priorityQueue, "queueName");

        PriorityQueue<Integer> priorityQueueWithComparator = new PriorityQueue<>(11, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if ((o1 + o2) % 2 != 0) {
                    return o1 % 2 == 0 ? -1 : 1;
                } else {
                    return o1.compareTo(o2);
                }
            }
        });
        fillQueue(priorityQueueWithComparator);
        printQueue(priorityQueueWithComparator, "priorityQueueWithComparator");
    }

    private static void printQueue(Queue<Integer> queue, String queueName) {
        System.out.print(queueName + ": ");
        while (!queue.isEmpty()) {
            System.out.print(queue.poll() + " ");
        }
        System.out.println();
    }

    private static void fillQueue(Queue<Integer> queue) {
        queue.add(5);
        queue.add(4);
        queue.add(3);
        queue.add(2);
        queue.add(1);
    }
}
