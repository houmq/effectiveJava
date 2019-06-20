package com.hmq.study.chapter6;

import java.math.RoundingMode;

/**
 * 枚举与注解
 *
 *
 * Created by  Hmq
 * @date on 2019/2/28.
 */
public class EnumAndAnnotation {




    public enum Planet{

        MERCURY(1 ,2),
        VENUS(3 ,4);

        private final int x;
        private final int y;


        Planet(int x, int y) {
            this.x = x;
            this.y = y;
        }


        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }

    public static void main(String[] args) {
//        System.out.println(Planet.MERCURY);
//
//        for (Planet p : Planet.values()) {
//            System.out.println(p.getX());
//        }

//        RoundingMode

//        System.out.println(Operation2.PLUS.apply(1 , 2));
//        System.out.println(Operation3.MINUS.apply(5 , 1));
//        System.out.println(Operation3.MINUS.toString());
        System.out.println(Operation3.PLUS.getOrdinal());


    }




    public enum Operation{
        PLUS,MINUS,TIMES,DIVIDE;


        double apply(double x ,double y){
            switch (this){
                case PLUS : return x + y;
                case MINUS : return x - y;
                case TIMES : return x * y;
                case DIVIDE : return x / y;
            }
            throw new AssertionError("Unknow up" + this);
        }
    }

    /**
     * 特定于常量方法实现
     * @author Hmq
     * @date 2019/3/6 11:32
     */
    public enum Operation2{
        PLUS{double apply(double x, double y) {return x + y;}},
        MINUS{double apply(double x, double y) {return x - y;}},
        TIMES{double apply(double x, double y) {return x * y;}},
        DIVIDE{double apply(double x, double y) {return x / y;}};

        abstract double apply(double x,double y);

    }


    /**
     * 特定于常量方法实现与
     * 特定于常量数据结合
     * @author Hmq
     * @date 2019/3/6 11:37
     */
    public enum Operation3{

        MINUS("-"){double apply(double x, double y) {return x - y;}},
        TIMES("*"){double apply(double x, double y) {return x * y;}},
        DIVIDE("/"){double apply(double x, double y) {return x / y;}},
        PLUS("+"){double apply(double x, double y) {return x + y;}};


        abstract double apply(double x,double y);

        private final String symbol;

        Operation3(String symbol) {
            this.symbol = symbol;
        }

        @Override
        public String toString() {
            return "Operation3 == { " + symbol + " }";
        }

        public int getOrdinal(){
            return ordinal();
        }


    }



}
