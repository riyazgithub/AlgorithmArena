package com.recursion;

import java.util.ArrayList;
import java.util.List;

public class permutationLearn {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutation = new ArrayList<>();
        permute_help(nums,permutation, new ArrayList<>());
        return permutation;
    }

    private void permute_help(int[] nums, List<List<Integer>> permutation, List<Integer> slate) {
        // base condition
        if(slate.size() == nums.length) {
            permutation.add(new ArrayList<>(slate));
            return;
        }
        for(int num : nums) {
            if(!slate.contains(num)){
                slate.add(num);
                permute_help(nums, permutation, slate);
                slate.remove(slate.size()-1);
            }
        }
    }
    public static void main(String[] args) {

    }
}
