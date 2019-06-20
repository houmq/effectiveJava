package com.hmq.study.concurrency.chapter5;

import java.util.Vector;

/**
 * Created by  Hmq
 *
 * @date on 2019/3/16.
 */
public class UnsafeVectorHelpers {
    public static Object getLast(Vector list) {
        int lastIndex = list.size() - 1;
        return list.get(lastIndex);
    }

    public static void deleteLast(Vector list) {
        int lastIndex = list.size() - 1;
        list.remove(lastIndex);
    }







}