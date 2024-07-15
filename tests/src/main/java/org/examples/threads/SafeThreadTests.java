package org.examples.threads;

import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Logger;

public class SafeThreadTests {

    private int count = 0;
    private final ReentrantLock lock = new ReentrantLock();

    public void increment() {
        lock.lock();
        try {
            count++;
        } finally {
            lock.unlock();
        }
    }

    public int getCount() {
        lock.lock();
        try {
            return count;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        Logger logger = Logger.getLogger("SafeThreadTests.class");

        SafeThreadTests counter = new SafeThreadTests();

        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        };

        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(task);
            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (ThreadDeath | InterruptedException e) {
                logger.info(e.getLocalizedMessage());
                Thread.currentThread().interrupt();
            }
        }

        logger.info("Final count: " + counter.getCount());
    }
}