package com.hmq.study.chapter10;

import java.util.concurrent.*;

/**
 * Created by  Hmq
 *
 * @date on 2019/3/11.
 */
public class Concurrent {



    private static boolean stopRequested;


    private static synchronized void stop(){
        stopRequested = true;
    }

    private static synchronized boolean isStop(){
        return stopRequested;
    }

    public static void main(String[] args) throws InterruptedException{
//        Thread t = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                int i = 0;
//                while (!isStop()){
//                    i++;
//                    System.out.println(i);
//                }
//
//            }
//        });
//
//        t.start();
//        TimeUnit.SECONDS.sleep(1);
//
//        stop();

        Executor executor = Executors.newFixedThreadPool(5);
        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("====" + Thread.currentThread().getName());
            }
        });

        System.out.println(timer(executor,4,a));


    }






    public static long timer(Executor executor ,int concurrency
            ,final Runnable action) throws InterruptedException{
        final CountDownLatch ready = new CountDownLatch(concurrency);
        final CountDownLatch start = new CountDownLatch(1);
        final CountDownLatch done = new CountDownLatch(concurrency);

        for (int i = 0; i < concurrency; i++) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    ready.countDown();
                    try {
                        start.await();
                        action.run();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        Thread.currentThread().interrupt();
                    }finally {
                        done.countDown();
                    }
                }
            });
        }

        ready.await();
        long startTime = System.nanoTime();
        start.countDown();
        done.await();
        return System.nanoTime() - startTime;
    }






}
