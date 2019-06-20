package com.hmq.study.concurrency;

/**
 *
 * Created by  Hmq
 * @NotThreadSafe
 * @date on 2019/3/14.
 */
public class LazyInitRace {
    private ExpensiveObject instance = null;

    public ExpensiveObject getInstance() {
        if (instance == null){
            instance = new ExpensiveObject();
        }
        return instance;
    }
}

class ExpensiveObject { }
