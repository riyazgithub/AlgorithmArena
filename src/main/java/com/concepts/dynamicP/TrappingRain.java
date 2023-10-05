package com.concepts.dynamicP;

import java.util.Arrays;

public class TrappingRain {
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int ans = 0;
        int size = height.length;
        int[] leftMax = new int[size];
        int[] rightMax = new int[size];
        int[] solMax = new int[size];

        leftMax[0] = height[0];
        for (int i = 1; i < size; i++) {
            leftMax[i] = Math.max(height[i], leftMax[i - 1]);
        }
        System.out.println("Lmax "+Arrays.toString(leftMax));
        rightMax[size - 1] = height[size - 1];
        for (int i = size - 2; i >= 0; i--) {
            rightMax[i] = Math.max(height[i], rightMax[i + 1]);
        }
        System.out.println("Right Max "+ Arrays.toString(rightMax));
        for (int i = 1; i < size - 1; i++) {
            ans += Math.min(leftMax[i], rightMax[i]) - height[i];
            solMax[i] = Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        System.out.println("Sol Max "+Arrays.toString(solMax));
        return ans;
    }

    public static void main(String[] args) {
        TrappingRain tr = new TrappingRain();
        int[] height = {2,1,4,3,2,2,4,3};
        System.out.println("Solution "+tr.trap(height));
    }
}
