package com.wxt.leetcode;

public class ClimbStairs_70_DP {

    public static void main(String[] args) {

        System.out.println(new ClimbStairs_70_DP().climbStairs(4));
    }

    public int climbStairs(int n) {
        if (n<2){
            return n;
        }

        int first=0;
        int second=1;
        while(n-->0){
            int temp=first+second;
            first=second;
            second=temp;
        }
        return second;
    }

}
