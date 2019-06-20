package com.hmq.study.concurrency.chapter3;

/**
 * Created by  Hmq
 *
 * @date on 2019/3/15.
 */
public class CountingSheep {
    volatile boolean asleep;

    void tryToSleep() {
        while (!asleep)
            countSomeSheep();
    }

    void countSomeSheep() {
        // One, two, three...
    }
}
