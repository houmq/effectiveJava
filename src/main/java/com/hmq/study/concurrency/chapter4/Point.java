package com.hmq.study.concurrency.chapter4;

import jdk.nashorn.internal.ir.annotations.Immutable;

/**
 * Created by  Hmq
 *
 * @date on 2019/3/16.
 */
@Immutable
public class Point {
    public final int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}