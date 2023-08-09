package com.search;

public class binarySearch {

    public int search(int[] nums, int target) {
        return search(nums, target, 0, nums.length-1);
    }

    private int search(int[] nums, int target, int begin, int end) {
        if(begin > end )
            return -1;
        int mid = (begin+end) /2;
        if(nums[mid] > target)
            return search(nums, target, begin, mid-1);
        else
            if (nums[mid] < target)
            return search(nums, target, mid+1, end);
        else
            return mid;
    }

    public static void main(String[] args) {

        int[] nums = {1,2,3,4,5,6,7,8,9,10};
        binarySearch b = new binarySearch();
        System.out.println(b.search(nums, 8));
        System.out.println(b.search(nums, 11));
        System.out.println(b.search(nums, 1));
        System.out.println(b.search(nums, 0));
        System.out.println(b.search(nums, 9));
    }
}
