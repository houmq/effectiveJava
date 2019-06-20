package com.hmq.study.concurrency.chapter4;

import java.util.Vector;

/**
 * Created by  Hmq
 * @ThreadSafe
 * @date on 2019/3/16.
 */
public class BetterVector <E> extends Vector<E> {
    // When extending a serializable class, you should redefine serialVersionUID
    static final long serialVersionUID = -3963416950630760754L;

    public synchronized boolean putIfAbsent(E x) {
        boolean absent = !contains(x);
        if (absent)
            add(x);
        return absent;
    }
}
