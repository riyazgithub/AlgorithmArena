package com.ds.array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;

/**
 * 300. Longest Increasing Subsequence
 */
public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int[] dp =  new int[nums.length];
        Arrays.fill(dp,1);
        for(int i = 1;i<nums.length;i++){
            for(int j=0; j< i; j++){
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[j]+1, dp[i]);
                }
            }
        }
        int maxValue = Arrays.stream(dp).max().orElseThrow(NoSuchElementException::new);
        return maxValue;
    }
    public int lengthOfLIS_NotWorking(int[] nums) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        maxHeap.offer(nums[0]);
        int count =1, tmpCount =1;
        for (int i = 1; i< nums.length; i++){
            if(nums[i] > maxHeap.peek()){
                maxHeap.offer(nums[i]);
                tmpCount++;
            }
            else {
                while(maxHeap.size() !=0 && nums[i] <= maxHeap.peek()) {
                    maxHeap.poll();
                    tmpCount--;
                }
                maxHeap.offer(nums[i]);
                tmpCount++;
            }
            if(count < tmpCount)
                count = tmpCount;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {0,1,0,3,2,3};
        LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
        System.out.println("Count "+ lis.lengthOfLIS_NotWorking(nums));
        System.out.println("Count "+ lis.lengthOfLIS(nums));

        nums = new int[]{4,10,4,3,8,9};
        System.out.println("Count "+ lis.lengthOfLIS_NotWorking(nums));
        System.out.println("Count "+ lis.lengthOfLIS(nums));
        nums = new int[]{7,7,7,7,7,7,7};
        System.out.println("Count "+ lis.lengthOfLIS_NotWorking(nums));
        System.out.println("Count "+ lis.lengthOfLIS(nums));
    }

}
