package com.wxt.leetcode;

import java.util.HashSet;
import java.util.Set;


public class lengthOfLongestSubstring_3 {

    public static void main(String[] args) {

        String test = "abcabcbb";
        System.out.println(situation1(test));

    }

    public static int situation1(String s) {
        int maxLength = 0;

        Set<Character> set = new HashSet<>();
        int nextIndex = 0;
        for (int i = 0; i < s.length(); i++) {

            if (i > 0) {
                set.remove(s.charAt(i - 1));
            }


            while (nextIndex<s.length()&&!set.contains(s.charAt(nextIndex))) {
                set.add(s.charAt(nextIndex));
                nextIndex++;
            }

            maxLength = Math.max(maxLength, nextIndex - i);
        }

        return maxLength;
    }


}
