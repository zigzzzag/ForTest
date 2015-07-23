package com.mnikiforov.advanced_java.multi_thread.test;

import com.mnikiforov.advanced_java.multi_thread.Operations;
import com.mnikiforov.advanced_java.multi_thread.transfer.Transfer;
import com.mnikiforov.advanced_java.multi_thread.transfer.TransferWithLock;

/**
 * Created by SBT-Nikiforov-MO on 30.06.2015.
 */
public class TestByTransferWithLock {

    public static void main(String[] args) {
        Transfer transfer = new TransferWithLock();
        Operations.testByTransfer(transfer);
    }
}
