package com.wxt.leetcode;

public class IsSubsequence_329 {

    public static void main(String[] args) {
        String s = "ab";
        String t = "baab";
        System.out.println(new IsSubsequence_329().isSubsequence(s, t));
    }

    public boolean isSubsequence(String s, String t) {
        if (t == null || s == null) {
            return false;
        }
        if (s.length() == 0) {
            return true;
        }
        if (t.length() == 0) {
            return false;
        }

        boolean result = false;
        char[] sub = s.toCharArray();
        int[] dp = new int[s.length()];
        for (int i = 0; i < sub.length; i++) {
            int index = t.indexOf(sub[i]);
            if (index == -1) {
                result = false;
                break;
            } else {
                result = true;
                dp[i] = index;
            }
            if (i != 0) {
                if (index > dp[i - 1]) {
                    result = true;
                } else {
                    result = false;
                }
            }
        }

        return result;
    }
}
