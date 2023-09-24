package org.union4dev.omni.util;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Multithreading {

    private static final ScheduledExecutorService RUNNABLE_POOL = Executors.newScheduledThreadPool(Integer.MAX_VALUE, new ThreadFactory() {
        private final AtomicInteger counter = new AtomicInteger(0);

        @Override
        public Thread newThread(Runnable r) {
            return new Thread(r, "Multithreading Thread " + counter.incrementAndGet());
        }
    });

    public static ExecutorService POOL = Executors.newCachedThreadPool(new ThreadFactory() {
        private final AtomicInteger counter = new AtomicInteger(0);

        @Override
        public Thread newThread(Runnable r) {
            return new Thread(r, "Multithreading Thread " + counter.incrementAndGet());
        }
    });

    public static void execute(Runnable r) {
        RUNNABLE_POOL.execute(r);
    }

    public static int getTotal() {
        return ((ThreadPoolExecutor) POOL).getActiveCount();
    }

    public static void runAsync(Runnable runnable) {
        POOL.execute(runnable);
    }
}
