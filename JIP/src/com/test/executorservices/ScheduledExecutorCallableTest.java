package com.test.executorservices;

import java.util.concurrent.*;

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
