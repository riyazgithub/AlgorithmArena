package com.concepts.dynamicP;

/**
 * 70. Climbing Stairs
 * You are climbing a staircase. It takes n steps to reach the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */

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
