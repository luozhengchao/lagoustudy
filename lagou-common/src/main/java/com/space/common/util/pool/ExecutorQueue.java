package com.space.common.util.pool;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.RejectedExecutionException;

/**
 * designed by PENGJIAWEI039
 *
 * @author: PENGJIAWEI039
 * @DATE: 2019-02-26 10:05
 */
public class ExecutorQueue extends LinkedTransferQueue<Runnable>
{
    private static final long serialVersionUID = -265236426751004839L;
    private StandardThreadExecutor threadPoolExecutor;

    public void setStandardThreadExecutor(StandardThreadExecutor threadPoolExecutor)
    {
        this.threadPoolExecutor = threadPoolExecutor;
    }

    public boolean force(Runnable o) {
        if (this.threadPoolExecutor.isShutdown()) {
            throw new RejectedExecutionException("Executor not running, can't force a command into the queue");
        }
        return super.offer(o);
    }

    public boolean offer(Runnable o)
    {
        int poolSize = this.threadPoolExecutor.getPoolSize();

        if (poolSize == this.threadPoolExecutor.getMaximumPoolSize()) {
            return super.offer(o);
        }
        if (this.threadPoolExecutor.getSubmittedTasksCount() <= poolSize) {
            return super.offer(o);
        }

        if (poolSize < this.threadPoolExecutor.getMaximumPoolSize()) {
            return false;
        }
        return super.offer(o);
    }
}
