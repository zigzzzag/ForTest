package com.mnikiforov.advanced_java.multi_thread.test;

import com.mnikiforov.advanced_java.multi_thread.Operations;
import com.mnikiforov.advanced_java.multi_thread.transfer.Transfer;
import com.mnikiforov.advanced_java.multi_thread.transfer.TransferWithLockTimeout;

/**
 * Created by SBT-Nikiforov-MO on 30.06.2015.
 */
public class TestByTransferWithLockTimeout {

    public static void main(String[] args) {
        Transfer transfer = new TransferWithLockTimeout();
        Operations.testByTransfer(transfer);
    }
}
