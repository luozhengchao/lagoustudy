package com.space.common.util.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * designed by PENGJIAWEI039
 *
 * @author: PENGJIAWEI039
 * @DATE: 2019-03-22 9:38
 */
public class ExecutorPoolUtil {

    private ExecutorPoolUtil() {
    }

    public static final ExecutorService EXECUTOR_REQUEST_OPERATION_SERVICE = new StandardThreadExecutor(10, 20, 60L, TimeUnit.SECONDS, 50, new StandardThreadFactory("request-log-pool"));

}
