package com.hmq.study.test;

public class Fibonacci {


    /**
     * Fibonacci
     * 迭代
     * @author hmq
     * @date 2019/6/24 17:45
     */
    static int Fibonacci(int number) {
        if (number <= 0) {
            return 0;
        }
        if (number == 1 || number == 2) {
            return 1;
        }
        int first = 1, second = 1, third = 0;
        for (int i = 3; i <= number; i++) {
            third = first + second;
            first = second;
            second = third;
        }
        return third;
    }

    /**
     * Fibonacci2
     * 递归
     * @author hmq
     * @date 2019/6/24 17:45
     */
    public static  int Fibonacci2(int n) {

        if (n <= 0) {
            return 0;
        }
        if (n == 1 || n == 2 ) {
            return 1;
        }

        return Fibonacci2(n - 2) + Fibonacci2(n - 1);

    }




    static int[] fibonacci3(int length){
        int[] result = new int[length];
        result[0] = 1;
        result[1] = 1;
        for (int i = 2; i < length; i++) {
            result[i] = result[i - 1] + result[i - 2];
        }
        return result;
    }

    public static void main(String[] args) {
        for (int i : fibonacci3(10)) {
            System.out.println(i);
        }

        System.out.println(Fibonacci(9));

    }


}
