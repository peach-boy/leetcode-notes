package com.wxt.leetcode;

public class MaxProfit_121_DP {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(new MaxProfit_121_DP().maxProfit(prices));
    }

    public int maxProfit(int[] prices) {
        if (prices.length == 1) {
            return 0;
        }

        int maxProfit = 0;
        int minPrice=0;
        for (int i = 0; i < prices.length; i++) {
            if (i==0){
                minPrice=prices[i];
                continue;
            }

            if (prices[i]<minPrice){
                minPrice=prices[i];
            }else{
                maxProfit=Math.max(prices[i]-minPrice,maxProfit);
            }
        }

        return maxProfit;
    }

}
