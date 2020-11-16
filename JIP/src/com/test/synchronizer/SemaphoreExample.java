package com.test.synchronizer;

import java.util.concurrent.Semaphore;

public class SemaphoreExample {
    public static void main(String[] args) {

    }

}

class Restaurant {
    Semaphore table;

    Restaurant(Semaphore semaphore) {
        this.table = semaphore;
    }

    public Semaphore getTable() {
        try {
            table.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
        }
        return table;
    }
}