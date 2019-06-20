package com.hmq.study.chapter1;

import java.io.Serializable;

/**
 * Created by  Hmq
 * @date on 2019/2/21.
 */
public class Singleton implements Serializable {

    private static final long serialVersionUID = -719389745195877189L;
    private static final Singleton INSTANCE = new Singleton();

    private Singleton() {
    }

    public static Singleton getInstance(){
        return INSTANCE;
    }

    // readResolve 可以防止反序列化
    private Object readResolve(){
        return INSTANCE;
    }

    public static void main(String[] args) {
        Singleton2 instance = Singleton2.INSTANCE;
        Singleton2 instance1 = Singleton2.INSTANCE;
        System.out.println(instance == instance1);
    }


}

// 单个枚举的Singleton
enum Singleton2{
    INSTANCE;

    public void doSomething(){
        System.out.println("aaa");
    }
}
