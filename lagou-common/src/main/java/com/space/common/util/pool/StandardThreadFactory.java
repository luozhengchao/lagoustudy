package com.space.common.util.pool;


import javax.validation.constraints.NotNull;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * designed by PENGJIAWEI039
 *
 * @author: PENGJIAWEI039
 * @DATE: 2019-02-26 10:06
 */
public class StandardThreadFactory implements ThreadFactory {
    private final AtomicInteger poolNumber = new AtomicInteger(1);
    private final ThreadGroup group;
    private final AtomicInteger threadNumber = new AtomicInteger(1);
    private final String namePrefix;

    public StandardThreadFactory(String namePrefix)
    {
        SecurityManager s = System.getSecurityManager();
        this.group = ((s != null) ? s.getThreadGroup() : Thread.currentThread().getThreadGroup());
        this.namePrefix = namePrefix + "-" + this.poolNumber.getAndIncrement() + "-thread-";
    }
    /**
     * Constructs a new {@code Thread}.  Implementations may also initialize
     * priority, name, daemon status, {@code ThreadGroup}, etc.
     *
     * @param r a runnable to be executed by new thread instance
     * @return constructed thread, or {@code null} if the request to
     * create a thread is rejected
     */
    @Override
    public Thread newThread(@NotNull Runnable r) {
        Thread t = new Thread(this.group, r, this.namePrefix + this.threadNumber
                .getAndIncrement(), 0L);

        if (t.isDaemon()) {
            t.setDaemon(false);
        }
        if (t.getPriority() != 5) {
            t.setPriority(5);
        }
        return t;
    }
}
