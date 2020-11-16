package com.test.executorservices;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorRepeatTest {
    private static int counter = 0;

    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);

        Runnable task = () -> {
            counter++;
            System.out.println("Task executed count:" + counter);
        };
        //Run task in every 1 second, initial delay 5 sec
        ScheduledFuture<?> scheduledFuture = executorService.scheduleAtFixedRate(task, 5, 1, TimeUnit.SECONDS);

        while (true) {

            System.out.println("counter: " + counter);
            Thread.sleep(1000);

            if (counter == 5) {
                System.out.println("Counter 5. cancel task");
                scheduledFuture.cancel(true);
                executorService.shutdown();
                break;
            }
        }
    }
}
