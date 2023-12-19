package com.concepts.dynamicP;

public class JumpWays {
    static Long jump_ways(Integer n) {
        // Write your code here.
        Long[] jumps = new Long[]{0L,1L,2L};
        for(int w = 3; w <=n; w++){
           jumps[w%3] = jumps[(w-1)%3] + jumps[(w-2)%3];
        }
        return jumps[n%3];
    }
    public int jump(int[] nums) {
        // The starting range of the first jump is [0, 0]
        int answer = 0, n = nums.length;
        int curEnd = 0, curFar = 0;

        for (int i = 0; i < n - 1; ++i) {
            // Update the farthest reachable index of this jump.
            curFar = Math.max(curFar, i + nums[i]);

            // If we finish the starting range of this jump,
            // Move on to the starting range of the next jump.
            if (i == curEnd) {
                answer++;
                curEnd = curFar;
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        System.out.println(jump_ways(3));
        System.out.println(jump_ways(10));
        int[] nums = {1,1,0,0,4};
        JumpWays jw = new JumpWays();
        System.out.println("Jump Ways "+jw.jump(nums));
    }
}
