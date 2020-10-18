package com.space.common.util.pool;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * designed by PENGJIAWEI039
 *
 * @author: PENGJIAWEI039
 * @DATE: 2019-02-25 20:18
 */
@Slf4j
public class StandardThreadExecutor extends ThreadPoolExecutor {
    public static final int DEFAULT_MIN_THREADS = 1;
    public static final int DEFAULT_MAX_THREADS = Runtime.getRuntime().availableProcessors() + 1;
    public static final int DEFAULT_MAX_IDLE_TIME = 60000;
    private static final ThreadFactory DEFAULT_THREAD_FACTORY = new StandardThreadFactory("StandardThreadPool");
    protected AtomicInteger submittedTasksCount;
    private int maxSubmittedTaskCount;

    public StandardThreadExecutor() {
        this(1, DEFAULT_MAX_THREADS);
    }

    public StandardThreadExecutor(int coreThread, int maxThreads) {
        this(coreThread, maxThreads, maxThreads);
    }

    public StandardThreadExecutor(int coreThread, int maxThreads, ThreadFactory threadFactory) {
        this(coreThread, maxThreads, maxThreads, threadFactory);
    }

    public StandardThreadExecutor(int coreThread, int maxThreads, long keepAliveTime, TimeUnit unit) {
        this(coreThread, maxThreads, keepAliveTime, unit, maxThreads);
    }

    public StandardThreadExecutor(int coreThreads, int maxThreads, int queueCapacity) {
        this(coreThreads, maxThreads, queueCapacity, DEFAULT_THREAD_FACTORY);
    }

    public StandardThreadExecutor(int coreThreads, int maxThreads, int queueCapacity, ThreadFactory threadFactory) {
        this(coreThreads, maxThreads, 60000L, TimeUnit.MILLISECONDS, queueCapacity, threadFactory);
    }

    public StandardThreadExecutor(int coreThreads, int maxThreads, long keepAliveTime, TimeUnit unit, int queueCapacity) {
        this(coreThreads, maxThreads, keepAliveTime, unit, queueCapacity, DEFAULT_THREAD_FACTORY);
    }

    public StandardThreadExecutor(int coreThreads, int maxThreads, long keepAliveTime, TimeUnit unit, int queueCapacity, ThreadFactory threadFactory) {
        this(coreThreads, maxThreads, keepAliveTime, unit, queueCapacity, threadFactory, new AbortPolicy());
    }

    public StandardThreadExecutor(int coreThreads, int maxThreads, long keepAliveTime, TimeUnit unit, int queueCapacity, ThreadFactory threadFactory, RejectedExecutionHandler handler) {
        super(coreThreads, maxThreads, keepAliveTime, unit, new ExecutorQueue(), threadFactory, handler);
        ((ExecutorQueue) getQueue()).setStandardThreadExecutor(this);

        this.submittedTasksCount = new AtomicInteger(0);

        this.maxSubmittedTaskCount = (queueCapacity + maxThreads);
    }

    public void execute(Runnable command) {
        int count = this.submittedTasksCount.incrementAndGet();

        if (count > this.maxSubmittedTaskCount) {
            this.submittedTasksCount.decrementAndGet();
            getRejectedExecutionHandler().rejectedExecution(command, this);
        }
        try {
            super.execute(command);
        } catch (RejectedExecutionException rx) {
            if (!(((ExecutorQueue) getQueue()).force(command))) {
                this.submittedTasksCount.decrementAndGet();

                getRejectedExecutionHandler().rejectedExecution(command, this);
            }
        }
    }

    public int getSubmittedTasksCount() {
        return this.submittedTasksCount.get();
    }

    public int getMaxSubmittedTaskCount() {
        return this.maxSubmittedTaskCount;
    }

    protected void afterExecute(Runnable r, Throwable t) {
        this.submittedTasksCount.decrementAndGet();
        printException(r, t);
    }

    private void printException(Runnable r, Throwable t) {
        if ((t == null) && (r instanceof Future)) {
            try {
                Future future = (Future) r;
                if (future.isDone())
                    future.get();
            } catch (CancellationException ce) {
                t = ce;
            } catch (ExecutionException ee) {
                t = ee.getCause();
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
            }
        }
        if (t != null)
            log.error(t.getMessage(), t);
    }
}