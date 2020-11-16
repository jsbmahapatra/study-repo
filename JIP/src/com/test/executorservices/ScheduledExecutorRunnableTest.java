package com.test.executorservices;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Schedule a Task to execute with initial delay :
 * 3 Tasks are there : Task1, Task2, Task3.
 * Task2 is scheduled to start by 5 Milli Sec delay.
 * By that time Task1 & Task3 will be executed and then Task2 will be executed
 * Note : Task2 is a Runnable task.
 */
public class ScheduledExecutorRunnableTest {
    public static void main(String[] args) {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);

        Runnable task2 = () -> {
            System.out.println("Running Task2");
        };
        task1();
        executorService.schedule(task2, 5, TimeUnit.SECONDS);
        task3();
        executorService.shutdown();
    }

    private static void task1() {
        System.out.println("Running Task1");
    }

    private static void task3() {
        System.out.println("Running Task3");
    }
}

