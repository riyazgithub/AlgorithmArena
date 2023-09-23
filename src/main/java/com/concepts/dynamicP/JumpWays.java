package com.concepts.dynamicP;

public class JumpWays {
    static Long jump_ways(Integer n) {
        // Write your code here.
        Long[] jumps = new Long[]{0l,1l,2l};
        for(int w = 3; w <=n; w++){
           jumps[w%3] = jumps[(w-1)%3] + jumps[(w-2)%3];
        }
        return jumps[n%3];
    }

    public static void main(String[] args) {
        System.out.println(jump_ways(3));
        System.out.println(jump_ways(10));
    }
}
