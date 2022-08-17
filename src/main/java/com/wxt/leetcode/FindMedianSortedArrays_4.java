package com.wxt.leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FindMedianSortedArrays_4 {

    public static void main(String[] args) {

        int[] num1={5,2,7};
        int[] num2={4,1,3,8};
        double list=findMedianSortedArrays(num1,num2);
        System.out.println(list);
    }

    private static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Double> list1 = Arrays.stream(nums1).mapToDouble(Double::valueOf).boxed().collect(Collectors.toList());
        List<Double> list2 = Arrays.stream(nums2).mapToDouble(Double::valueOf).boxed().collect(Collectors.toList());
        list1.addAll(list2);

        for (int i = 0; i < list1.size(); i++) {
            for (int j = i + 1; j < list1.size(); j++) {
                Double temp;
                if (list1.get(i) > list1.get(j)) {
                    temp=list1.get(i);
                    list1.set(i,list1.get(j));
                    list1.set(j,temp);
                }
            }
        }

        int size=list1.size();
        if (size%2==0){
            int s=size/2;
            double number=(list1.get(s)+list1.get(s-1))/2;
            return number;
        } else{
            int s=size/2;
            return list1.get(s);
        }
    }
}
