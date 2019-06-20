package com.hmq.study.concurrency.chapter7;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by  Hmq
 *
 * @date on 2019/3/20.
 */
public class TimedRun1 {
    private static final ScheduledExecutorService cancelExec = Executors.newScheduledThreadPool(1);

    public static void timedRun(Runnable r, long timeout, TimeUnit unit) {
        final Thread taskThread = Thread.currentThread();
        cancelExec.schedule(new Runnable() {
            public void run() {
                taskThread.interrupt();
            }
        }, timeout, unit);
        r.run();
    }


    public static void main(String[] args) {
        TimedRun1.timedRun(new Runnable() {
            @Override
            public void run() {
                System.out.println("1");
            }
        },60,TimeUnit.SECONDS);
    }


}
