package com.wxt.leetcode;

public class LongestPalindrome_5 {
    public static void main(String[] args) {
        String testStr = "cbbd";
        System.out.println(longestPalindrome(testStr));
    }


    private static String longestPalindrome(String s) {
        int middleIndex = 0;
        int offset = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char leftChar = ' ';
            char rightChar = ' ';
            int tempOffset = 0;
            for (; tempOffset < n; ) {
                int leftIndex = i - tempOffset;
                int rightIndex = i + tempOffset;
                if (leftIndex < 0) {
                    break;
                } else {
                    leftChar = s.charAt(leftIndex);
                }

                if (rightIndex > n - 1) {
                    break;
                } else {
                    rightChar = s.charAt(rightIndex);
                }

                //左右字符相等，则加1
                if (rightChar == leftChar) {
                    tempOffset++;
                } else {
                    break;
                }
            }

            if (tempOffset-1 > offset) {
                offset = tempOffset - 1;
                middleIndex = i;
            }
        }


        int beginIndex = middleIndex - offset;
        int endIndex=middleIndex+offset+1;
        String resultSubtr = s.substring(beginIndex<0?0:beginIndex,endIndex>n?n:endIndex);
        return resultSubtr;
    }
}
