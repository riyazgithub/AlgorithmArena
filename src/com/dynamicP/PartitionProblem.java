package com.dynamicP;

import java.util.HashMap;

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
public class PartitionProblem {

    // Solution 1: Brute force
    // Time Complexity: O(n^2)
    // Space Complexity: O(n)
    // n = number of elements in the array
    public static boolean partitionProblem(int[] set) {
        return false;
    }

    public static boolean canPartition(int[]num, HashMap<Integer, Integer> map)
    {
        for(int i : num) {
            int count = map.getOrDefault(i, 0);
            if(count > 0) {
                map.put(i, count - 1);
            } else {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {

        int[] set = {1, 2,3,4};
        int[][] subSet = {{1,2}, {3,1}};
        HashMap <Integer, Integer> map = new HashMap<>();
        populateMap(set, map);
        boolean result  = true;
        for(int[] sub : subSet) {
            result = result && canPartition(sub, map);
            if(!result)
                break;
        }
        System.out.println("Can Partition ? "+ result);
    }

    private static void populateMap(int[] set, HashMap<Integer, Integer> map) {
        for (int i = 0; i < set.length; i++) {
            Integer count = map.getOrDefault(set[i], 0);
            count++;
            map.put(set[i], count);
        }
    }

    private static boolean isSubset(int[] subset, int[] set) {
        return false;
    }
}
