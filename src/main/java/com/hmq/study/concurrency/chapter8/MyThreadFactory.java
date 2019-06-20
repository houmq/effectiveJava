package com.hmq.study.concurrency.chapter8;

import java.util.concurrent.ThreadFactory;

/**
 * Created by  Hmq
 *
 * @date on 2019/3/21.
 */
public class MyThreadFactory implements ThreadFactory {
    private final String poolName;

    public MyThreadFactory(String poolName) {
        this.poolName = poolName;
    }

    public Thread newThread(Runnable runnable) {
        return new MyAppThread(runnable, poolName);
    }
}
