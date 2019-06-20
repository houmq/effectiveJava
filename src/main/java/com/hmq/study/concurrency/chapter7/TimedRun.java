package com.hmq.study.concurrency.chapter7;

import com.hmq.study.concurrency.chapter5.LaunderThrowable;

import java.util.concurrent.*;

/**
 * Created by  Hmq
 *
 * @date on 2019/3/20.
 */
public class TimedRun {
    private static final ExecutorService taskExec = Executors.newCachedThreadPool();

    public static void timedRun(Runnable r, long timeout, TimeUnit unit) throws InterruptedException {
        Future<?> task = taskExec.submit(r);
        try {
            task.get(timeout, unit);
        } catch (TimeoutException e) {
            // task will be cancelled below
        } catch (ExecutionException e) {
            // exception thrown in task; rethrow
            throw LaunderThrowable.launderThrowable(e.getCause());
        } finally {
            // Harmless if task already completed
            task.cancel(true); // interrupt if running
        }
    }


}
