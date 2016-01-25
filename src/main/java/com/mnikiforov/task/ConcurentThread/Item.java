package com.mnikiforov.task.ConcurentThread;

/**
 * Created by sbt-nikiforov-mo on 25.01.16.
 */
public class Item {

    private long itemId;
    private long groupId;

    public Item(long itemId, long groupId) {
        this.itemId = itemId;
        this.groupId = groupId;
    }

    public Item() {
    }

    public long getItemId() {
        return itemId;
    }

    public void setItemId(long itemId) {
        this.itemId = itemId;
    }

    public long getGroupId() {
        return groupId;
    }

    public void setGroupId(long groupId) {
        this.groupId = groupId;
    }

    @Override
    public String toString() {
        return Thread.currentThread().getName() + ", itemId=" + itemId + ", groupId=" + groupId;
    }
}
