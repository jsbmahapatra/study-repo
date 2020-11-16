package com.test.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.StampedLock;

public class StampedOptimisticLock {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        StampedLock lock = new StampedLock();

        executorService.submit(() -> {
            long stamp = lock.tryOptimisticRead();
            try {
                System.out.println(Thread.currentThread() + " read lock acquired, " + stamp);
                System.out.println(Thread.currentThread() + "  Optimistic Lock validate: " + lock.validate(stamp));
                Thread.sleep(1000);
                System.out.println(Thread.currentThread() + " Optimistic Lock validate: " + lock.validate(stamp));
                //Thread.sleep(1000);
                System.out.println(Thread.currentThread() + " Optimistic Lock validate: " + lock.validate(stamp));
                // Thread.sleep(1000);
            } catch (Exception ex) {
            } finally {
                System.out.println(Thread.currentThread() + "releasing Write lock");
                lock.unlock(stamp);
            }

        });

        executorService.submit(() -> {
            long stamp = lock.writeLock();
            try {
                System.out.println(Thread.currentThread() + " Write lock acquired, " + stamp);
                Thread.sleep(2000);
            } catch (Exception ex) {
            } finally {
                System.out.println(Thread.currentThread() + "releasing Write lock");
                lock.unlock(stamp);
            }

        });

        executorService.shutdown();
    }
}
