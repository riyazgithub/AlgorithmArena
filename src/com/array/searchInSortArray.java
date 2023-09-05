package com.array;

public class searchInSortArray {
    public int search(int[] nums, int target) {

        // Find Pivot
        int s =0, e=nums.length-1;
        int m = -1;
        while(s<e) {
            m = (int) ((e-s) * 0.5);
            if(nums[s] > nums[m])
                e = m;
            else if(nums[m] > nums[e])
                s =m;
        }
        System.out.println(String.format("s: %s, e: %s, m: %s ",s,e,m));
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {4,5,6,7,0,1,2};
        searchInSortArray sia = new searchInSortArray();
        System.out.println(sia.search(nums, 0));
    }
}
