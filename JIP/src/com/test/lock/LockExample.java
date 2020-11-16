package com.test.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockExample {
    Lock lock = new ReentrantLock();
    int counter = 0;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(() -> {
            LockExample lock1 = new LockExample();
            lock1.increment();
        });

        executorService.submit(() -> {
            LockExample lock1 = new LockExample();
            lock1.increment();
        });
        executorService.shutdown();

    }

    public void increment() {
        lock.lock();
        try {
            counter++;
            System.out.println(Thread.currentThread());
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
