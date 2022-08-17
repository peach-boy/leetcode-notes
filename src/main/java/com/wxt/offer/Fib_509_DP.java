package com.wxt.offer;

public class Fib_509_DP {
    public int fib(int n) {
        if (n <2) {
            return n;
        }

        int mod = 1000000007;
        int first = 0;
        int second = 1;
        while (n-- > 0) {
            int temp = (first + second)% mod;
            first = second ;
            second = temp;
        }
        return first;
    }

    public static void main(String[] args) {
        System.out.println(new Fib_509_DP().fib(5));
    }
}
