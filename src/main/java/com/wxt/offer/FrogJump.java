package com.wxt.offer;

public class FrogJump {
    public int numWays(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 1;
        }

        int first = 1;
        int second = 1;
        int mod = 1000000007;
        while (n-- > 0) {
            int temp = first + second;
            first = second % mod;
            second = temp % mod;
        }
        return first;
    }
}
