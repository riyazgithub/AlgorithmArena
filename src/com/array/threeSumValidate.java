package com.array;

import java.util.*;

public class threeSumValidate {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> ret = new HashSet<>();
        if(nums.length < 3) return new ArrayList<>(ret);
        Arrays.sort(nums);
        int pivot, s, e;
        for(int i =0; i<nums.length-2; i++) {
            e=nums.length-1;
            s =i+1;
            pivot = nums[i];
            int sum = -1;
            while (s < e) {
                sum = pivot + nums[s] + nums[e];
                if(sum < 0) s++;
                else if(sum > 0) e--;
                else {
                    ArrayList<Integer> al = new ArrayList<>();
                    al.add(nums[i]);al.add(nums[s]);al.add(nums[e]);
                    ret.add(al);
                    s++;
                }
            }
        }
        return new ArrayList<>(ret);
    }

    public static void main(String[] args) {
        threeSumValidate ts = new threeSumValidate();
        int[] nums = new int[] {-1,0,1,2,-1,-4};
        System.out.println(ts.threeSum(nums));
        nums = new int[] {0,0,0};
        System.out.println(ts.threeSum(nums));
        nums = new int[] {0,0,0,0};
        System.out.println(ts.threeSum(nums));
        nums = new int[] {-2,0,1,1,2};
        System.out.println(ts.threeSum(nums));
    }
}
