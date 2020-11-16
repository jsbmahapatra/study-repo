package com.test.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class SemaphoreExample {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(6);
        Semaphore semaphore = new Semaphore(5);

        Runnable task = () -> {
            boolean permit = false;
            try {
                permit = semaphore.tryAcquire(1, TimeUnit.SECONDS);
                if (permit) {
                    System.out.println(Thread.currentThread() + " acquired lock");
                    Thread.sleep(500);
                } else {
                    System.out.println(Thread.currentThread() + " could nt get lock");
                }
            } catch (Exception ex) {
            } finally {
                if (permit) {
                    semaphore.release();
                }
            }
        };
        IntStream.range(0, 10).forEach(i -> {
            executorService.submit(task);
        });
        executorService.shutdown();
    }
}
