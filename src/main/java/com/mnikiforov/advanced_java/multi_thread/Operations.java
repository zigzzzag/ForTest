package com.mnikiforov.advanced_java.multi_thread;

import com.mnikiforov.advanced_java.multi_thread.transfer.Transfer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by SBT-Nikiforov-MO on 22.06.2015.
 */
public class Operations {

    private static final Logger log = LoggerFactory.getLogger(Operations.class);
    public static final int POOL_SIZE = 4;

    public static void testByTransfer(Transfer transfer) {
        final Account gogiAcc = new Account("Gogi Account", 1000);
        final Account dodoAcc = new Account("Dodo Account", 2000);

        TransferInfo transferInfo1 = new TransferInfo().acc1(gogiAcc).acc2(dodoAcc).amount(500);
        TransferInfo transferInfo2 = new TransferInfo().acc1(dodoAcc).acc2(gogiAcc).amount(300);

        Thread t1 = new Thread(new OperationProc(transfer, transferInfo1));
        Thread t2 = new Thread(new OperationProc(transfer, transferInfo2));

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
            log.info("testByTransfer finished!!! '{}':{}    '{}':{}", gogiAcc.getName(), gogiAcc.getBalance(), dodoAcc.getName(), dodoAcc.getBalance());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void testByTransfer(Transfer transfer, int countOperations) {
        final Account gogiAcc = new Account("Gogi Account", 1000);
        final Account dodoAcc = new Account("Dodo Account", 2000);

        ExecutorService ex = Executors.newFixedThreadPool(POOL_SIZE);

        for (int i = 0; i < countOperations / 2; i++) {
            TransferInfo transferInfo1 = new TransferInfo().acc1(gogiAcc).acc2(dodoAcc).amount(50);
            TransferInfo transferInfo2 = new TransferInfo().acc1(dodoAcc).acc2(gogiAcc).amount(50);

            ex.submit(new OperationProc(transfer, transferInfo1));
            ex.submit(new OperationProc(transfer, transferInfo2));
        }
        ex.shutdown();

        ScheduledExecutorService scheduledService = Executors.newSingleThreadScheduledExecutor();
        Runnable r = new Runnable() {
            @Override
            public void run() {
                log.info("gogiAcc failCounter: {}; dodoAcc failCounter: {}", gogiAcc.getFailLockCount(), dodoAcc.getFailLockCount());
            }
        };
        scheduledService.scheduleAtFixedRate(r, 1000, 1000, TimeUnit.MILLISECONDS);

        try {
            ex.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
            scheduledService.shutdown();
            log.info("testByTransfer finished!!! '{}':{}    '{}':{}", gogiAcc.getName(), gogiAcc.getBalance(), dodoAcc.getName(), dodoAcc.getBalance());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void testByTransferWithCallable(Transfer transfer) {
        final Account gogiAcc = new Account("Gogi Account", 1000);
        final Account dodoAcc = new Account("Dodo Account", 2000);

        ExecutorService ex = Executors.newFixedThreadPool(5);

        TransferInfo transferInfo1 = new TransferInfo().acc1(gogiAcc).acc2(dodoAcc).amount(500);
        TransferInfo transferInfo2 = new TransferInfo().acc1(dodoAcc).acc2(gogiAcc).amount(300);

        Future<TransferInfo> future1 = ex.submit(new OperationProcCallable(transfer, transferInfo1));
        Future<TransferInfo> future2 = ex.submit(new OperationProcCallable(transfer, transferInfo2));

        ex.shutdown();

        try {
            log.info("first transfer complete: {}", future1.get());
            log.info("second transfer complete: {}", future2.get());
            log.info("testByTransferWithCallable finished!!! '{}':{}    '{}':{}", gogiAcc.getName(), gogiAcc.getBalance(), dodoAcc.getName(), dodoAcc.getBalance());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    public static void testByTransferWithCallableCDL(Transfer transfer, int countOperations) {
        final Account gogiAcc = new Account("Gogi Account", 10_000);
        final Account dodoAcc = new Account("Dodo Account", 20_000);
        final Account ivanAcc = new Account("Ivan Account", 30_000);
        final Account petrAcc = new Account("Petr Account", 40_000);

        ExecutorService ex = Executors.newFixedThreadPool(POOL_SIZE);
        CountDownLatch startCDL = new CountDownLatch(1);
        List<Future<TransferInfo>> futuresList = new ArrayList<>();

        for (int i = 0; i < countOperations / 2; i++) {
            TransferInfo transferInfo1 = new TransferInfo().acc1(gogiAcc).acc2(dodoAcc).amount(50);
            TransferInfo transferInfo2 = new TransferInfo().acc1(dodoAcc).acc2(ivanAcc).amount(50);
            TransferInfo transferInfo3 = new TransferInfo().acc1(ivanAcc).acc2(petrAcc).amount(50);
            TransferInfo transferInfo4 = new TransferInfo().acc1(petrAcc).acc2(gogiAcc).amount(50);

            Callable<TransferInfo> callable1 = new OperationProcCallable(transfer, transferInfo1).countDownLatch(startCDL);
            Callable<TransferInfo> callable2 = new OperationProcCallable(transfer, transferInfo2).countDownLatch(startCDL);
            Callable<TransferInfo> callable3 = new OperationProcCallable(transfer, transferInfo3).countDownLatch(startCDL);
            Callable<TransferInfo> callable4 = new OperationProcCallable(transfer, transferInfo4).countDownLatch(startCDL);

            futuresList.add(ex.submit(callable1));
            futuresList.add(ex.submit(callable2));
            futuresList.add(ex.submit(callable3));
            futuresList.add(ex.submit(callable4));
        }

        startCDL.countDown();
        ex.shutdown();

        try {
            ex.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
            log.info("testByTransferWithCallableCDL finished!!! {} {} {} {}",
                    gogiAcc, dodoAcc, ivanAcc, petrAcc);

            int failedTransferCount = 0;
            long maxTimeTransfer = 0;
            long minTimeTransfer = Long.MAX_VALUE;
            long totalTimeTransfer = 0;
            long averageTimeTransfer = 0;

            for (Future<TransferInfo> future : futuresList) {
                TransferInfo transferInfo = future.get();

                totalTimeTransfer += transferInfo.getTotalTimeMillis();

                if (transferInfo.getTotalTimeMillis() > maxTimeTransfer) {
                    maxTimeTransfer = transferInfo.getTotalTimeMillis();
                }

                if (transferInfo.getTotalTimeMillis() < minTimeTransfer) {
                    minTimeTransfer = transferInfo.getTotalTimeMillis();
                }

                if (!transferInfo.isSucces()) {
                    failedTransferCount++;
                }
            }
            averageTimeTransfer = totalTimeTransfer / futuresList.size();

            log.info("failed transfer: {} of {}", failedTransferCount, futuresList.size());
            log.info("maxTimeTransfer:     {}ms", maxTimeTransfer);
            log.info("minTimeTransfer:     {}ms", minTimeTransfer);
            log.info("totalTimeTransfer:   {}ms", totalTimeTransfer);
            log.info("averageTimeTransfer: {}ms", averageTimeTransfer);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
