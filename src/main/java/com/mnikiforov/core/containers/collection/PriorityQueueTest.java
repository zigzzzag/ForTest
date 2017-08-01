package com.mnikiforov.core.containers.collection;

import java.util.PriorityQueue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PriorityQueueTest {

    private static final Logger LOG = LoggerFactory.getLogger(PriorityQueueTest.class);

    public static void main(String[] args) {
        Item item1 = new Item(1);
        Item item2 = new Item(2);
        Item item3 = new Item(3);
        Item item4 = new Item(4);


        PriorityQueue<Item> testQueue = new PriorityQueue<>();
        testQueue.add(item1);
        testQueue.add(item2);
        testQueue.add(item3);
        testQueue.add(item4);

        while (!testQueue.isEmpty()) {
            LOG.info("{0}", testQueue.poll());
        }
        LOG.info("");

        testQueue.add(item1);
        testQueue.add(item2);
        testQueue.add(item3);
        testQueue.add(item4);

        item1.setData(5);// queue doesn't reorder

        while (!testQueue.isEmpty()) {
            LOG.info("{0}", testQueue.poll());
        }
    }

    private static class Item implements Comparable<Item> {
        private int data;

        Item(int data) {
            this.data = data;
        }

        public void setData(int data) {
            this.data = data;
        }

        @Override
        public int compareTo(Item o) {
            return this.data - o.data;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Item)) return false;

            Item item = (Item) o;

            return data == item.data;
        }

        @Override
        public int hashCode() {
            return data;
        }

        @Override
        public String toString() {
            return "Item{" +
                    "data=" + data +
                    '}';
        }
    }
}
