package com.hmq.study.concurrency.chapter4;

/**
 * Created by  Hmq
 *
 * @date on 2019/3/16.
 */
public class PrivateLock {
    private final Object myLock = new Object();

    void someMethod() {
        synchronized (myLock) {
            // Access or modify the state of widget
        }
    }
}