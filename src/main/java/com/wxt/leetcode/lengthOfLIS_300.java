package com.wxt.leetcode;

public class lengthOfLIS_300 {

    public static void main(String[] args) {
        int[] nums = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(lengthOfLIS(nums));
    }

    public static int lengthOfLIS(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }

        int maxNum = 1;
        int[] dp=new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i]=1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
            maxNum=Math.max(maxNum,dp[i]);
        }

        return maxNum;
    }
}
