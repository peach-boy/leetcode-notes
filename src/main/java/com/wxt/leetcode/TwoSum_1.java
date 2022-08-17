package com.wxt.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoSum_1 {

    public static void main(String[] args) {

        int[] array = {2, 7, 11, 4, 7};
        int[] result = twoSum(array, 9);
        System.out.println(result);

    }

    public static int[] twoSum(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                int firstNum = array[i];
                int secondNum = array[j];
                if (firstNum + secondNum == target) {
                    return new int[]{i,j};
                }
            }
        }

       return new int[]{};
    }

}
