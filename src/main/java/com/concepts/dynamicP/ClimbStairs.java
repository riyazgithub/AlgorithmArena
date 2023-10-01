package com.concepts.dynamicP;

public class ClimbStairs {
    public int climbStairs(int n) {
        int[] cs = new int[n+1];
        if(n <= 1) {
            return n;
        }
        cs[0] = 0;
        cs[1] = 1;
        cs[2] = 2;
        for(int i = 3; i<n+1; i++){
            cs[i] = cs[i-1] +cs[i-2];
        }
        return cs[n];
    }
}
