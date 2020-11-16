package com.test.executorservices;

import java.util.concurrent.*;

/**
 * Schedule a Task to execute with initial delay :
 * 3 Tasks are there : Task1, Task2, Task3.
 * Task2 is scheduled to start by 5 Milli Sec delay.
 * By that time Task1 & Task3 will be executed and then Task2 will be executed
 * Note : Task2 is a Callable task we can use its result.
 */
public class ScheduledExecutorCallableTest {
    public static void main(String[] args) {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(10);

        Callable<Integer> task2 = () -> 10;
        ScheduledFuture<Integer> schedule = executorService.schedule(task2, 5, TimeUnit.MILLISECONDS);

        task1();
        task3();
        try {
            System.out.println(schedule.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        executorService.shutdown();

    }

    private static void task3() {
        System.out.println("Running Task3");
    }

    private static void task1() {
        System.out.println("Running Task1");
    }
}
