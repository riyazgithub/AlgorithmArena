package com.concepts.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UniqueSubSets {

    /**
     * Given an integer array nums of unique elements, return all possible
     * subsets
     *  (the power set).
     *
     * The solution set must not contain duplicate subsets. Return the solution in any order.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [1,2,3]
     * Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
     * Example 2:
     *
     * Input: nums = [0]
     * Output: [[],[0]]
     * @param args
     */

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> uniqueSubset = new ArrayList<>();
        subset_Help(0, uniqueSubset, new ArrayList<Integer>(), nums);
        return uniqueSubset;
    }

    private void subset_Help(int i, List<List<Integer>> uniqueSubset, List<Integer> slate, int[] nums) {
        if(i == nums.length){
            uniqueSubset.add(new ArrayList<>(slate));
            return;
        }
        subset_Help(i+1, uniqueSubset, slate, nums);
        slate.add(nums[i]);
        subset_Help(i+1, uniqueSubset, slate, nums);
        slate.remove(slate.size()-1);
    }

    public List<List<Integer>> subsets1(int[] nums) {
        List<List<Integer>> uniqueSubset = new ArrayList<>();
        subset_Help1(nums, uniqueSubset, new ArrayList<Integer>(), 0);
        return uniqueSubset;
    }
    private void subset_Help1(int[] nums, List<List<Integer>> subsetU, List<Integer> slate, int index) {
        subsetU.add(new ArrayList<>(slate));
        for(int i = index; i<nums.length; i++) {
            slate.add(nums[i]);
            subset_Help1(nums, subsetU, slate, i +1);
            slate.remove(slate.size()-1);
        }
    }
    /**
     * Given an integer array nums that may contain duplicates, return all possible
     * subsets
     *  (the power set).
     *
     * The solution set must not contain duplicate subsets. Return the solution in any order.
     *
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> subsetU = new ArrayList<>();
        Arrays.sort(nums);
        List<Integer> slate = new ArrayList<>();
        subsetsWithDupHelp(nums, subsetU, slate, 0);
        return subsetU;
    }



    private void subsetsWithDupHelp(int[] nums, List<List<Integer>> subsetU, List<Integer> slate, int index) {
            subsetU.add(new ArrayList<>(slate));
        for(int i = index; i<nums.length; i++) {
            if (i != index && nums[i] == nums[i - 1]) {
                continue;
            }
            slate.add(nums[i]);
            subsetsWithDupHelp(nums, subsetU, slate, i +1);
            slate.remove(slate.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        UniqueSubSets uss = new UniqueSubSets();
        System.out.println("Subset help "+ uss.subsets(nums));
        System.out.println("Subset help "+ uss.subsets1(nums));
        nums = new int[]{1,2,2};
        System.out.println("Subset help "+ uss.subsetsWithDup(nums));

    }
}
