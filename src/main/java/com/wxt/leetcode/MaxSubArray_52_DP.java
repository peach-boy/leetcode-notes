package com.wxt.leetcode;

public class MaxSubArray_52_DP {

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(new MaxSubArray_52_DP().maxSubArray(nums));
    }

    public int maxSubArray(int[] nums) {
        if (nums.length==1){
            return nums[0];
        }

        int[] dp = new int[nums.length];
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (i==0){
                dp[i] = nums[i];
            }else{
                dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            }
            if (dp[i] > maxSum) {
                maxSum = dp[i];
            }
        }
        return maxSum;
    }
}
