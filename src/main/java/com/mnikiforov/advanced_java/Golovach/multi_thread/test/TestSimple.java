package com.mnikiforov.advanced_java.Golovach.multi_thread.test;

import com.mnikiforov.advanced_java.Golovach.multi_thread.Account;
import com.mnikiforov.advanced_java.Golovach.multi_thread.OperationProc;
import com.mnikiforov.advanced_java.Golovach.multi_thread.TransferInfo;
import com.mnikiforov.advanced_java.Golovach.multi_thread.transfer.TransferSimple;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by SBT-Nikiforov-MO on 30.06.2015.
 */
public class TestSimple {

    private static final Logger log = LoggerFactory.getLogger(TestSimple.class);

    public static void main(String[] args) {
        ExecutorService ex = Executors.newFixedThreadPool(5);

        final Account gogiAcc = new Account("Gogi Account", 100_000);
        final Account dodoAcc = new Account("Dodo Account", 200_000);

        for (int i = 0; i < 10000; i++) {
            TransferInfo transferInfo1 = new TransferInfo().acc1(gogiAcc).acc2(dodoAcc).amount(50);
            TransferInfo transferInfo2 = new TransferInfo().acc1(dodoAcc).acc2(gogiAcc).amount(50);

            ex.submit(new OperationProc(new TransferSimple(), transferInfo1));
            ex.submit(new OperationProc(new TransferSimple(), transferInfo2));
        }

        ex.shutdown();

        try {
            ex.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            log.error(e.getMessage(), e);
        }

        log.info("testSimple finished!!! '{}':{}    '{}':{}", gogiAcc.getName(), gogiAcc.getBalance(), dodoAcc.getName(), dodoAcc.getBalance());
    }
}
