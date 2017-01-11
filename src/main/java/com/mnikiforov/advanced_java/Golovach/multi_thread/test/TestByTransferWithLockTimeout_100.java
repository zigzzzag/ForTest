package com.mnikiforov.advanced_java.Golovach.multi_thread.test;

import com.mnikiforov.advanced_java.Golovach.multi_thread.Operations;
import com.mnikiforov.advanced_java.Golovach.multi_thread.transfer.Transfer;
import com.mnikiforov.advanced_java.Golovach.multi_thread.transfer.TransferWithLockTimeout;

/**
 * Created by zigzzzag on 30.06.2015.
 */
public class TestByTransferWithLockTimeout_100 {

    public static void main(String[] args) {
        Transfer transfer = new TransferWithLockTimeout();
        Operations.testByTransfer(transfer, 100);
    }
}
