package com.mnikiforov.advanced_java.multi_thread.test;

import com.mnikiforov.advanced_java.multi_thread.Operations;
import com.mnikiforov.advanced_java.multi_thread.transfer.Transfer;
import com.mnikiforov.advanced_java.multi_thread.transfer.TransferWithLockTimeout;

/**
 * Created by SBT-Nikiforov-MO on 01.07.2015.
 */
public class TestByTransferWithCallableCDL {

    public static void main(String[] args) {
        Transfer transfer = new TransferWithLockTimeout();
        Operations.testByTransferWithCallableCDL(transfer, 20);
    }
}
