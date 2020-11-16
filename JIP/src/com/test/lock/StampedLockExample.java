package com.test.lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.StampedLock;

public class StampedLockExample {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        StampedLock lock = new StampedLock();

        executorService.submit(() -> {
            long stamp = lock.writeLock();
            try {
                System.out.println(Thread.currentThread() + " acquiring write lock ," + stamp);
                Thread.sleep(1000);
                map.put("test", "testV");
            } catch (Exception ex) {
            } finally {
                System.out.println(Thread.currentThread() + " releasing write lock");
                lock.unlockWrite(stamp);
            }
        });

        Runnable readTask = () -> {
            long stamp = lock.readLock();
            try {
                System.out.println(Thread.currentThread() + " acquired read lock," + stamp);
                System.out.println(map.get("test"));
                Thread.sleep(1000);
            } catch (Exception ex) {
            } finally {
                System.out.println(Thread.currentThread() + " releasing read lock");
                lock.unlock(stamp);
            }


        };
        executorService.submit(readTask);
        executorService.submit(readTask);

        executorService.shutdown();

    }
}
