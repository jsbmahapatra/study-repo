package com.test.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.StampedLock;

public class StampedTryConvertWriteLockExample {
    @SuppressWarnings("Convert2Lambda")
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        StampedLock lock = new StampedLock();
        final int count = 0;
        executorService.submit(new MyTask(lock, count));
        executorService.shutdown();
    }

    static class MyTask implements Runnable {
        StampedLock lock;
        int count;

        MyTask(StampedLock lock, int count) {
            this.count = count;
            this.lock = lock;
        }

        @Override
        public void run() {
            long stamp = lock.readLock();
            try {
                if (count == 0) {
                    stamp = lock.tryConvertToWriteLock(stamp);
                    if (stamp == 0L) {
                        stamp = lock.writeLock();
                    }
                    count = 23;
                }
                System.out.println(count);
            } finally {
                lock.unlock(stamp);
            }
        }
    }
}
