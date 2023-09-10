package com.recursion;

import java.util.*;

/**
 * Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.
 *
 * Example 1:
 *
 * Input: nums = [1,1,2]
 * Output:
 * [[1,1,2],
 *  [1,2,1],
 *  [2,1,1]]
 */
public class UniquePermutation {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> permute = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        List<Integer> slate = new ArrayList<>();
        permuteUnique_help(nums, slate, used, permute);
        return permute;
    }

    private void permuteUnique_help(int[] nums, List<Integer> slate, boolean[] used, List<List<Integer>> permute) {
        if (slate.size() == nums.length)
        {
            permute.add(new ArrayList<>(slate));
            return;
        }
        HashSet<Integer> isSeen = new HashSet<>();
        for(int i=0; i< nums.length; i++){
            if(!used[i] && !isSeen.contains(nums[i])) {
                isSeen.add(nums[i]);
                used[i] = true;
                slate.add(nums[i]);
                permuteUnique_help(nums, slate, used, permute);
                used[i] = false;
                slate.remove(slate.size()-1);
            }
        }
    }


    public static void main(String[] args) {
        UniquePermutation solution = new UniquePermutation();
        int[] nums = {1, 1, 2};
        List<List<Integer>> permutations = solution.permuteUnique(nums);
        for (List<Integer> permutation : permutations) {
            System.out.println(permutation);
        }
    }
}
