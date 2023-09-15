package com.ds.array;

import java.util.Arrays;

public class selfProduct {
    public int[] productExceptSelf(int[] nums) {
        int[] pro = new int[nums.length];
        int[] prefix = new int[nums.length];
        int[] suffix = new int[nums.length];

        // initialize
        prefix[0] = 1; suffix[nums.length-1] = 1;
        for (int i =1; i< nums.length; i++) {
            prefix[i] = prefix[i-1] * nums[i-1];
            suffix[nums.length-1-i]  = suffix[nums.length-i] *  nums[nums.length-i];
        }
        for(int i =0; i< nums.length; i++) {
           pro[i] = prefix[i] * suffix[i];
        }

        return pro;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {0,1,2,3,4};
        selfProduct sp = new selfProduct();
        System.out.println("Out put "+ Arrays.toString(sp.productExceptSelf(nums)));

    }
}
