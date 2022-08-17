package com.wxt.leetcode;

public class NFib_1137_DP {

    public static void main(String[] args) {
        System.out.println(new NFib_1137_DP().tribonacci(25));
    }
    public int tribonacci(int n) {
        if (n < 2) {
            return n;
        }
        if (n == 2) {
            return 1;
        }
        int first = 0;
        int second = 1;
        int third = 1;
        for (int i = 2; i < n; i++) {
            int temp=first+second+third;
            first=second;
            second=third;
            third=temp;
        }

        return third;
    }
}
