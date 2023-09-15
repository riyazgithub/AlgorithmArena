package com.concepts.dynamicP;

/**
 * Problem statement
 * Given an array of integers, write a function to find if any two subsets of the input array exist such that the sum of both subsets is equal. You can assume that the array will only consist of positive integers.
 *
 * Input
 * An array of positive integers.
 *
 * Output
 * The output is a boolean. It will be True if such subsets exist and False if they do not.
 *
 * Sample input
 * int set[] = {1, 2, 3, 4};
 * Sample output
 * true          // (The 2 subsets will be 1,4 & 2,3)
 */

public class PartitionProblemBrute {
    public static boolean partitionProblem(int[] set) {
        int sum =0;
        for(int i=0;i<set.length;i++)
            sum+=set[i];
        if(sum%2!=0)
            return false;
        else
            return partitionProblemRecursive(set, sum/2, 0);
    }

    private static boolean partitionProblemRecursive(int[] set, int sum, int currIndex) {

        if(currIndex >= set.length || sum < 0)
            return false;
        if(sum == 0)
            return true;
        if(set[currIndex] <= sum) {
            if(partitionProblemRecursive(set, sum - set[currIndex], currIndex+1))
                return true;
        }
        return partitionProblemRecursive(set, sum, currIndex+1);
    }

    public static void main(String[] args) {
        int[] set = {1, 2, 3, 4, 6};
        System.out.println("Partition one " + PartitionProblemBrute.partitionProblem(set));
    }
}
