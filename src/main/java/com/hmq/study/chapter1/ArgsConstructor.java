package com.hmq.study.chapter1;

/**
 * 第一章-2
 * 多参数时可使用构造器模式 （重载构造器）
 *
 * JavaBean 模式 无参构造 set参数 无法保证线程安全
 *
 * Builder模式
 *
 * Created by  Hmq
 * @date on 2019/2/21.
 */
public class ArgsConstructor {

    private final int id;

    private final String name;

    private final int age;

    private final int stature;


    private ArgsConstructor(Builder builder){
        id = builder.id;
        name = builder.name;
        age = builder.age;
        stature = builder.stature;
    }


    // 静态成员类
    public static class Builder{

        private int id;

        private String name;

        private int age;

        private int stature;

        public Builder(int id) {
            this.id = id;
        }

        // 构建器
        public ArgsConstructor Build() {
            return new ArgsConstructor(this);
        }


        public Builder name(String val){
            name = val;
            return this;
        }

        public Builder age(int val){
            age = val;
            return this;
        }

        public Builder stature(int val){
            stature = val;
            return this;
        }

    }

    public static void main(String[] args) {
        ArgsConstructor arg = new ArgsConstructor.Builder(1).name("hmq").age(25).stature(180).Build();
        System.out.println(arg.toString());
    }


}
