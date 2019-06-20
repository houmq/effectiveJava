package com.hmq.study.chapter8;

import java.util.Random;

/**
 * Created by  Hmq
 *
 * @date on 2019/3/8.
 */
public class Program {


    private static final Random rand = new Random();

    static int random(int n){
        return Math.abs(rand.nextInt()) % n;
    }


    public static void main(String[] args) {
        int n = 2 * (Integer.MAX_VALUE / 3);
        int low = 0;
        for (int i = 0; i < 1000000; i++) {
            if (random(n) < n/2){
                low++;
            }
        }
        System.out.println(low);
    }


}
