package com.mnikiforov.advanced_java.Golovach.multi_thread.test;

import com.mnikiforov.advanced_java.Golovach.multi_thread.Operations;
import com.mnikiforov.advanced_java.Golovach.multi_thread.transfer.Transfer;
import com.mnikiforov.advanced_java.Golovach.multi_thread.transfer.TransferWithLockTimeout;

/**
 * Created by zigzzzag on 01.07.2015.
 */
public class TestByTransferWithCallableCDL {

    public static void main(String[] args) {
        Transfer transfer = new TransferWithLockTimeout();
        Operations.testByTransferWithCallableCDL(transfer, 20);
    }
}
