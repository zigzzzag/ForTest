package com.mnikiforov.advanced_java.multi_thread;

import com.mnikiforov.advanced_java.multi_thread.transfer.Transfer;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

/**
 * Created by SBT-Nikiforov-MO on 30.06.2015.
 */
public class OperationProcCallable implements Callable<TransferInfo> {

    private TransferInfo transferInfo;
    private Transfer transfer;
    private CountDownLatch startCDL;

    public OperationProcCallable(Transfer transfer, TransferInfo transferInfo) {
        this.transfer = transfer;
        this.transferInfo = transferInfo;
    }

    public OperationProcCallable countDownLatch(CountDownLatch startCDL) {
        this.startCDL = startCDL;
        return this;
    }

    @Override
    public TransferInfo call() throws Exception {
        if (startCDL != null) {
            startCDL.await();
        }
        return transfer.transfer(transferInfo);
    }
}
