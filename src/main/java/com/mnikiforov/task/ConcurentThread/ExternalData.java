package com.mnikiforov.task.ConcurentThread;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by sbt-nikiforov-mo on 25.01.16.
 */
public enum ExternalData {

    INSTANCE;

    public static final long[] GROUP_ID_ARRAY = new long[]{1, 2, 3, 4, 5, 6, 7, 8};
    private Queue<Item> queue = new LinkedList<>();

    private ExternalData() {
    }

    public Queue<Item> getQueue() {
        return queue;
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
