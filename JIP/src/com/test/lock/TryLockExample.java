package com.test.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TryLockExample {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Lock lock = new ReentrantLock();

        executorService.submit(() -> {
            lock.lock();
            try {
                System.out.println("Thread1 took Lock ");
                Thread.sleep(1000);
            } catch (Exception ex) {
            } finally {
                System.out.println("Thread1 Releasing Lock ");
                lock.unlock();
            }
        });

        executorService.submit(() -> {
            boolean flag = lock.tryLock();
            try {
                System.out.println("Thread2 took Lock " + flag);
                Thread.sleep(2000);
            } catch (Exception ex) {
            } finally {
                System.out.println("Thread2 Releasing Lock ");
                lock.unlock();
            }
        });
        executorService.shutdown();

    }
}
