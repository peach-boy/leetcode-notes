package com.wxt.offer;

public class StockBestProfit {

    public static int maxProfit1(int[] prices) {
        int max=0;
        for (int i = 0; i < prices.length;i++) {
            int buyValue=prices[i];
            for (int j = i; j < prices.length; j++) {
                int saleValue=prices[j];
                int profit=saleValue-buyValue;
                if (profit>=0&&profit>max){
                    max=profit;
                }
            }
        }
        return max;
    }

    public static int maxProfit2(int[] prices) {
        int minvalue=Integer.MAX_VALUE;
        int max=0;
        for (int i = 0; i < prices.length;i++) {
           if (prices[i]<minvalue){
               minvalue=prices[i];
           }else if(prices[i]-minvalue>max){
               max=prices[i]-minvalue;
           }
        }
        return max;
    }

    public static void main(String[] args) {
        //System.out.println(maxProfit2(new int[]{7,1,5,3,6,4}));
        int i=1;
        System.out.println(i+++"--"+i);
        System.out.println(i+++"--"+i);
        System.out.println(++i+"--"+i);
        System.out.println(++i+"--"+i);

    }
}
