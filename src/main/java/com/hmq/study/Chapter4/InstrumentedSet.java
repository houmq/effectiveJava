package com.hmq.study.Chapter4;

import java.util.Collection;
import java.util.Set;

/**
 * 复合类设计（装饰者模式）
 * 类本身
 * 类目的：累加添加到集合的次数
 * Created by  Hmq
 * @date on 2019/2/25.
 */
public class InstrumentedSet<E> extends ForwardingSet<E> {

    private int addCount = 0;

    public InstrumentedSet(Set<E> s) {
        super(s);
    }

    @Override
    public boolean add(E e) {
        addCount ++ ;
        return super.add(e);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        addCount += c.size();
        return super.addAll(c);
    }

    public int getAddCount(){
        return addCount;
    }


}
