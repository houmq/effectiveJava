package com.hmq.study.concurrency.chapter4;

/**
 * Created by  Hmq
 *
 * @date on 2019/3/16.
 */
public final class Counter {
    private long value = 0;

    public synchronized long getValue() {
        return value;
    }

    public synchronized long increment() {
        if (value == Long.MAX_VALUE)
            throw new IllegalStateException("counter overflow");
        return ++value;
    }
}
