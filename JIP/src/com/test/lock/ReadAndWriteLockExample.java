package com.test.lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadAndWriteLockExample {
    public static void main(String[] args) {

        Map<String, String> map = new HashMap<>();
        ReadWriteLock lock = new ReentrantReadWriteLock();

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        executorService.submit(() -> {
            lock.writeLock().lock();
            try {
                System.out.println("Thread1 acquiring write lock");
                Thread.sleep(2000);
                map.put("test", "testValue");


            } catch (Exception ex) {
            } finally {
                System.out.println("Thread1 releasing write lock");
                lock.writeLock().unlock();
            }
        });

        Runnable readTask = () -> {
            lock.readLock().lock();
            try {
                System.out.println(Thread.currentThread() + " acquiring read lock");
                System.out.println(map.get("test"));
                Thread.sleep(2000);
            } catch (Exception ex) {
            } finally {
                System.out.println(Thread.currentThread() + "  releasing read lock");
                lock.readLock().unlock();
            }
        };
        executorService.submit(readTask);
        executorService.submit(readTask);

        executorService.shutdown();

    }
}
