package com.array;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
 *
 * Find two lines that together with the x-axis form a container, such that the container contains the most water.
 *
 * Return the maximum amount of water a container can store.
 *
 * Notice that you may not slant the container.
 *
 * Input: height = [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
 * Example 2:
 *
 * Input: height = [1,1]
 * Output: 1
 */

public class maxWaterHold {
    public int maxArea(int[] height) {
        int max_so_far = 0;
        // two pinter approach
        int start =0, end = height.length-1;
        while(start < end) {
                int volume = Math.min(height[end], height[start]) * (end - start);
                if(volume > max_so_far)
                    max_so_far = volume;
                if(height[start] < height[end])
                    start++;
                else end--;

            }

        return max_so_far;
    }

    public static void main(String[] args) {

        maxWaterHold mw = new maxWaterHold();
        System.out.println(String.format("For Array %s the maxCapacity %s","1,8,6,2,5,4,8,3,7", mw.maxArea(new int[]{1,8,6,2,5,4,8,3,7})));
        System.out.println(String.format("For Array %s the maxCapacity %s","1,1", mw.maxArea(new int[]{1,1})));
    }
}
