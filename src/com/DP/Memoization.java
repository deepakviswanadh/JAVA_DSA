package com.DP;

public class Memoization {
    //dp+memoization+bottom-up
    public int climbStairs(int n) {
        int t1 = 1;
        int t2 = 1;
        for (int i = 0; i < n - 1; i++) {
            int s = t1 + t2;
            t2 = t1;
            t1 = s;
        }
        return t1;
    }
}
